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

@DisplayName("ParkingMeter calculateRate Test")
class ParkingMeterCalculateRateTest {
    private lateinit var parkingMeter: ParkingMeter

    @BeforeTest
    fun setup() {
        // Given: A parking meter with specific rate schedule and operation time
        val rateSchedule =
            RateSchedule(
                dayOfWeek = DayOfWeek.SATURDAY,
                ratePerHours =
                    listOf(
                        RatePerHour(
                            startHour = LocalTime.of(12, 0),
                            rate = Dollar(value = 2.0),
                        ),
                        RatePerHour(
                            startHour = LocalTime.of(13, 0),
                            rate = Dollar(value = 3.0),
                        ),
                        RatePerHour(
                            startHour = LocalTime.of(14, 0),
                            rate = Dollar(value = 4.0),
                        ),
                    ),
            )

        val maxTimePeriodPerDay =
            MaxTimePeriodPerDay(
                dayOfWeek = DayOfWeek.SATURDAY,
                maxTimePeriodPerHours =
                    listOf(
                        MaxTimePeriodPerHour(
                            startHour = LocalTime.of(12, 0),
                            duration = Minute(180),
                        ),
                    ),
            )

        parkingMeter =
            ParkingMeter(
                rateSchedule = listOf(rateSchedule),
                maxTimePeriodPerDays = listOf(maxTimePeriodPerDay),
                meterOperationTime =
                    TimePeriod(
                        startTime = LocalTime.of(8, 0),
                        endTime = LocalTime.of(20, 0),
                    ),
            )
    }

    @Nested
    @DisplayName("calculateRate method")
    inner class CalculateRateTest {
        // Common test date - Saturday, April 12, 2025
        private val testDate = LocalDateTime.of(2025, 4, 12, 12, 0)

        @Test
        @DisplayName("should calculate correct rate for a single hour")
        fun calculateRateForSingleHour() {
            // When: Parking for 1 hour from 12 PM
            val startTime = testDate
            val endTime = testDate.plusHours(1)

            val rate = parkingMeter.calculateRate(startTime, endTime)

            // Then: Rate should be $2.0
            rate shouldBe 2.0
        }

        @Test
        @DisplayName("should calculate correct rate for a partial hour")
        fun calculateRateForPartialHour() {
            // When: Parking for 30 minutes from 12 PM
            val startTime = testDate
            val endTime = testDate.plusMinutes(30)

            val rate = parkingMeter.calculateRate(startTime, endTime)

            // Then: Rate should be $1.0 (half of the hourly rate)
            rate shouldBe 1.0
        }

        @Test
        @DisplayName("should calculate correct rate spanning multiple rate periods")
        fun calculateRateSpanningMultiplePeriods() {
            // When: Parking from 12 PM to 2:30 PM (spans three rate periods)
            val startTime = testDate
            val endTime = testDate.plusHours(2).plusMinutes(30)

            val rate = parkingMeter.calculateRate(startTime, endTime)

            // Then: Rate should be $2.0 (first hour) + $3.0 (second hour) + $2.0 (half of third hour) = $7.0
            rate shouldBe 7.0
        }

        @Test
        @DisplayName("should throw exception when end time is before start time")
        fun throwsExceptionWhenEndTimeIsBeforeStartTime() {
            // When & Then: Exception occurs when end time is before start time
            assertThrows<IllegalArgumentException> {
                parkingMeter.calculateRate(
                    startTime = testDate,
                    endTime = testDate.minusMinutes(1),
                )
            }
        }

        @Test
        @DisplayName("should throw exception when maximum parking duration is exceeded")
        fun throwsExceptionWhenMaxDurationExceeded() {
            // When & Then: Exception occurs when maximum parking duration is exceeded
            assertThrows<IllegalArgumentException> {
                parkingMeter.calculateRate(
                    startTime = testDate,
                    // Exceeds 3-hour maximum
                    endTime = testDate.plusHours(4),
                )
            }
        }

        @Test
        @DisplayName("should throw exception when parking time is outside meter operation hours")
        fun throwsExceptionWhenOutsideOperationHours() {
            // When & Then: Exception occurs when parking extends beyond meter operation hours
            assertThrows<IllegalArgumentException> {
                parkingMeter.calculateRate(
                    startTime = testDate,
                    // Past 8 PM operation end time
                    endTime = testDate.withHour(21),
                )
            }
        }

        @Test
        @DisplayName("should calculate correct rate when parking starts at non-zero minutes")
        fun calculateRateWithNonZeroStartMinutes() {
            // When: Parking from 12:30 PM to 1:30 PM
            val startTime = testDate.plusMinutes(30)
            val endTime = startTime.plusHours(1)

            val rate = parkingMeter.calculateRate(startTime, endTime)

            // Then: Rate should be partial of first hour (30 min at $2.0/hr) and partial of second hour (30 min at $3.0/hr)
            // = $1.0 + $1.5 = $2.5
            rate shouldBe 2.5
        }
    }
}
