package com.igoparking.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.BeforeTest

@DisplayName("ParkingMeter Test")
class ParkingMeterTest {
    private lateinit var parkingMeter: ParkingMeter

    @BeforeTest
    fun setup() {
        // Given: A parking meter allowing 2 hours of parking from 12 PM on Saturday
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
        parkingMeter = ParkingMeter(maxTimePeriodPerDays = listOf(maxTimePeriodPerDay))
    }

    @Nested
    @DisplayName("isValidMaxTimePeriod method")
    inner class ValidateMaxTimePeriodTest {
        // Common test date - Saturday, April 12, 2025
        private val testDate = LocalDateTime.of(2025, 4, 12, 12, 0)

        @Test
        @DisplayName("should be valid for parking requests within maximum allowed time")
        fun isValidForPermittedDuration() {
            // When: Request to park from 12 PM for exactly 2 hours on Saturday
            val isValidMaxTime =
                parkingMeter.isValidMaxTimePeriod(
                    startTime = testDate,
                    endTime = testDate.plusHours(2),
                )

            // When: Request to park from 12 PM for less than 2 hours on Saturday
            val isValidLessTime =
                parkingMeter.isValidMaxTimePeriod(
                    startTime = testDate,
                    endTime = testDate.plusHours(1).plusMinutes(59),
                )

            // Then: Both cases should be valid
            isValidMaxTime shouldBe true
            isValidLessTime shouldBe true
        }

        @Test
        @DisplayName("should be invalid for parking requests exceeding maximum allowed time")
        fun isInvalidForExceededDuration() {
            // When: Request to park from 12 PM for 2 hours and 1 minute on Saturday
            val isValid =
                parkingMeter.isValidMaxTimePeriod(
                    startTime = testDate,
                    endTime = testDate.plusHours(2).plusMinutes(1),
                )

            // Then: Should be invalid
            isValid shouldBe false
        }

        @Test
        @DisplayName("should throw exception when end time is before start time")
        fun throwsExceptionWhenEndTimeIsBeforeStartTime() {
            // When & Then: Exception occurs when end time is before start time
            assertThrows<IllegalArgumentException> {
                parkingMeter.isValidMaxTimePeriod(
                    startTime = testDate,
                    endTime = testDate.minusMinutes(1),
                )
            }
        }

        @Test
        @DisplayName("should throw exception when start date and end date are different")
        fun throwsExceptionWhenDatesAreDifferent() {
            // When & Then: Exception occurs when dates are different
            assertThrows<IllegalArgumentException> {
                parkingMeter.isValidMaxTimePeriod(
                    startTime = testDate,
                    endTime = testDate.plusDays(1),
                )
            }
        }
    }
}
