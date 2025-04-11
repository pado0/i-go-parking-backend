package com.igoparking.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.Test

class ParkingMeterTest {
    private fun createMeter(): ParkingMeter {
        val maxTimePeriodPerDay =
            MaxTimePeriodPerDay(
                dayOfWeek = DayOfWeek.SATURDAY,
                maxTimePeriodPerHours =
                    listOf(
                        MaxTimePeriodPerHour(
                            startHour = LocalTime.NOON,
                            duration = Minute(120),
                        ),
                    ),
            )
        return ParkingMeter(maxTimePeriodPerDays = listOf(maxTimePeriodPerDay))
    }

    @Test
    fun `validate max time period - can park in proper period`() {
        val parkingMeter = createMeter()
        val isValidInMaxHour =
            parkingMeter.isValidMaxTimePeriod(
                startTime = LocalDateTime.of(2025, 4, 12, 12, 0),
                endTime = LocalDateTime.of(2025, 4, 12, 14, 0),
            )

        val isValidInSpareTime =
            parkingMeter.isValidMaxTimePeriod(
                startTime = LocalDateTime.of(2025, 4, 12, 12, 0),
                endTime = LocalDateTime.of(2025, 4, 12, 13, 59),
            )

        isValidInMaxHour shouldBe true
        isValidInSpareTime shouldBe true
    }

    @Test
    fun `validate max time period - can not park in longer period`() {
        val parkingMeter = createMeter()
        val isValid =
            parkingMeter.isValidMaxTimePeriod(
                startTime = LocalDateTime.of(2025, 4, 12, 12, 0),
                endTime = LocalDateTime.of(2025, 4, 12, 14, 1),
            )

        isValid shouldBe false
    }

    @Test
    fun `validate max time period - throw exception - end time is before start time`() {
        val parkingMeter = createMeter()
        assertThrows<Exception> {
            parkingMeter.isValidMaxTimePeriod(
                startTime = LocalDateTime.of(2025, 4, 12, 11, 59),
                endTime = LocalDateTime.of(2025, 4, 12, 12, 0),
            )
        }
    }

    @Test
    fun `validate max time period - throw exception - different date`() {
        val parkingMeter = createMeter()
        assertThrows<Exception> {
            parkingMeter.isValidMaxTimePeriod(
                startTime = LocalDateTime.of(2025, 4, 12, 12, 0),
                endTime = LocalDateTime.of(2025, 4, 13, 0, 0),
            )
        }
    }
}
