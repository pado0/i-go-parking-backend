package com.igoparking.adapter.out.vancouver.opendata.client.mapper

import com.igoparking.adapter.out.vancouver.opendata.client.dto.Meter
import com.igoparking.domain.MaxTimePeriodPerDay
import com.igoparking.domain.MaxTimePeriodPerHour
import com.igoparking.domain.ParkingMeter
import com.igoparking.domain.RatePerHour
import com.igoparking.domain.RateSchedulePerDay
import com.igoparking.domain.TimePeriod
import com.igoparking.domain.unit.Minute
import com.igoparking.domain.unit.toDollar
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object ParkingMeterMapper {
    fun mapToDomainEntity(meter: Meter): ParkingMeter {
        val meterOperationTime: TimePeriod = buildMeterOperationTime(meter.timeineffe)
        val rateSchedulePerDays: List<RateSchedulePerDay> =
            buildRateSchedulePerDays(
                meter = meter,
                meterOperationTime = meterOperationTime,
            )
        val maxTimePeriodPerDays: List<MaxTimePeriodPerDay> =
            buildMaxTimePeriodPerDays(
                meter = meter,
                meterOperationTime = meterOperationTime,
            )
        return ParkingMeter(
            maxTimePeriodPerDays = maxTimePeriodPerDays,
            rateSchedulePerDays = rateSchedulePerDays,
            meterOperationTime = meterOperationTime,
        )
    }

    private fun buildMaxTimePeriodPerDays(
        meter: Meter,
        meterOperationTime: TimePeriod,
    ): List<MaxTimePeriodPerDay> {
        val weekdayDays =
            listOf(
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
            ).map { day ->
                MaxTimePeriodPerDay(
                    dayOfWeek = day,
                    maxTimePeriodPerHours =
                        buildMaxTimePeriodPerHour(
                            am = meter.t_mf_9a_6p,
                            pm = meter.t_mf_6p_10,
                            meterOperationTime = meterOperationTime,
                        ),
                )
            }

        val saturday =
            MaxTimePeriodPerDay(
                dayOfWeek = DayOfWeek.SATURDAY,
                maxTimePeriodPerHours =
                    buildMaxTimePeriodPerHour(
                        am = meter.t_sa_9a_6p,
                        pm = meter.t_sa_6p_10,
                        meterOperationTime = meterOperationTime,
                    ),
            )

        val sunday =
            MaxTimePeriodPerDay(
                dayOfWeek = DayOfWeek.SUNDAY,
                maxTimePeriodPerHours =
                    buildMaxTimePeriodPerHour(
                        am = meter.t_su_9a_6p,
                        pm = meter.t_su_6p_10,
                        meterOperationTime = meterOperationTime,
                    ),
            )

        return weekdayDays + saturday + sunday
    }

    fun buildMaxTimePeriodPerHour(
        am: String,
        pm: String,
        meterOperationTime: TimePeriod,
    ): List<MaxTimePeriodPerHour> {
        val amDuration = parseDuration(am)
        val pmDuration = parseDuration(pm)

        val start = meterOperationTime.startTime
        val end = meterOperationTime.endTime

        val hours = mutableListOf<MaxTimePeriodPerHour>()
        var current = start

        while (current.isBefore(end)) {
            val duration =
                if (current.isBefore(LocalTime.of(18, 0))) amDuration
                else pmDuration
            duration?.let { hours.add(MaxTimePeriodPerHour(current, it)) }
            current = current.plusHours(1)
        }
        return hours
    }

    fun parseDuration(value: String): Minute? =
        when {
            value.contains("No Time Limit", ignoreCase = true) -> null
            value.contains("Hr", ignoreCase = true) -> {
                val number = Regex("""\d+""").find(value)?.value?.toIntOrNull()
                number?.let { Minute(it * 60) }
            }

            else -> throw IllegalArgumentException("Invalid duration value '$value'")
        }

    private fun buildRateSchedulePerDays(
        meter: Meter,
        meterOperationTime: TimePeriod,
    ): List<RateSchedulePerDay> {
        val weekdayDays =
            listOf(
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
            ).map { day ->
                RateSchedulePerDay(
                    dayOfWeek = day,
                    ratePerHours =
                        buildRateHours(
                            am = meter.r_mf_9a_6p,
                            pm = meter.r_mf_6p_10,
                            meterOperationTime = meterOperationTime,
                        ),
                )
            }

        val saturday =
            RateSchedulePerDay(
                dayOfWeek = DayOfWeek.SATURDAY,
                ratePerHours =
                    buildRateHours(
                        am = meter.r_sa_9a_6p,
                        pm = meter.r_sa_6p_10,
                        meterOperationTime = meterOperationTime,
                    ),
            )

        val sunday =
            RateSchedulePerDay(
                dayOfWeek = DayOfWeek.SUNDAY,
                ratePerHours =
                    buildRateHours(
                        am = meter.r_su_9a_6p,
                        pm = meter.r_su_6p_10,
                        meterOperationTime = meterOperationTime,
                    ),
            )

        return weekdayDays + saturday + sunday
    }

    fun buildRateHours(
        am: String,
        pm: String,
        meterOperationTime: TimePeriod,
    ): List<RatePerHour> {
        val amRate = am.toDollar()
        val pmRate = pm.toDollar()

        val start = meterOperationTime.startTime
        val end = meterOperationTime.endTime

        val hours = mutableListOf<RatePerHour>()
        var current = start

        while (current.isBefore(end)) {
            val rate = if (current.isBefore(LocalTime.of(18, 0))) amRate else pmRate
            hours.add(RatePerHour(current, rate))
            current = current.plusHours(1)
        }

        return hours
    }

    fun buildMeterOperationTime(timeineffe: String): TimePeriod {
        val regex = Regex("""(\d{1,2}:\d{2} [AP]M) TO (\d{1,2}:\d{2} [AP]M)""")
        val matchResult =
            regex.find(timeineffe)
                ?: throw IllegalArgumentException("Invalid time format")

        val (start, end) = matchResult.destructured
        val formatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH)

        return TimePeriod(
            startTime = LocalTime.parse(start, formatter),
            endTime = LocalTime.parse(end, formatter),
        )
    }
}
