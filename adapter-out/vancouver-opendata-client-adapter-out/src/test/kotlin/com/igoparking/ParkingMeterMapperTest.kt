package com.igoparking

import com.igoparking.adapter.out.vancouver.opendata.client.dto.Meter
import com.igoparking.adapter.out.vancouver.opendata.client.mapper.ParkingMeterMapper
import com.igoparking.domain.TimePeriod
import com.igoparking.domain.unit.Minute
import com.igoparking.domain.unit.toDollar
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalTime

class ParkingMeterMapperTest {
    private fun mockMeter(): Meter =
        Meter(
            meterhead = "Pay Station",
            meterid = "120409",
            timeineffe = "9:00 AM TO 10:00 PM",
            rate_misc = "\$ .50",
            t_mf_9a_6p = "2 Hr",
            t_mf_6p_10 = "No Time Limit",
            t_sa_9a_6p = "1 Hr",
            t_sa_6p_10 = "2 Hr",
            t_su_9a_6p = "1 Hr",
            t_su_6p_10 = "2 Hr",
            r_mf_9a_6p = "$2.00",
            r_mf_6p_10 = "$3.00",
            r_sa_9a_6p = "$1.50",
            r_sa_6p_10 = "$2.50",
            r_su_9a_6p = "$1.00",
            r_su_6p_10 = "$2.00",
        )

    @Test
    fun `should parse TimePeriod correctly`() {
        val timeineffe = "9:00 AM TO 10:00 PM"
        val result = ParkingMeterMapper.buildMeterOperationTime(timeineffe)

        result.startTime shouldBe LocalTime.of(9, 0)
        result.endTime shouldBe LocalTime.of(22, 0)
    }

    @Test
    fun `should parse duration correctly`() {
        ParkingMeterMapper.parseDuration("2 Hr") shouldBe Minute(120)
        ParkingMeterMapper.parseDuration("No Time Limit") shouldBe null
    }

    @Test
    fun `should build rate hours correctly`() {
        val rates =
            ParkingMeterMapper.buildRateHours(
                am = "$1.00",
                pm = "$2.00",
                meterOperationTime = TimePeriod(LocalTime.of(9, 0), LocalTime.of(22, 0)),
            )

        rates shouldHaveSize 13
        rates.first().rate shouldBe "1.00".toDollar()
        rates.last().rate shouldBe "2.00".toDollar()
    }

    @Test
    fun `should build max time period hours correctly - if no limit set to null`() {
        val hours =
            ParkingMeterMapper.buildMaxTimePeriodPerHour(
                am = "1 Hr",
                pm = "No Time Limit",
                meterOperationTime = TimePeriod(LocalTime.of(9, 0), LocalTime.of(22, 0)),
            )

        hours shouldHaveSize 9
    }

    @Test
    fun `should build full ParkingMeter domain from Meter DTO`() {
        val meter = mockMeter()
        val domain = ParkingMeterMapper.mapToDomainEntity(meter)

        domain.rateSchedulePerDays?.shouldHaveSize(7)
        domain.maxTimePeriodPerDays?.shouldHaveSize(7)

        val mondayRate = domain.rateSchedulePerDays?.first { it.dayOfWeek == DayOfWeek.MONDAY }
        mondayRate?.ratePerHours?.first()?.rate shouldBe "2.00".toDollar()
        mondayRate?.ratePerHours?.last()?.rate shouldBe "3.00".toDollar()
    }
}
