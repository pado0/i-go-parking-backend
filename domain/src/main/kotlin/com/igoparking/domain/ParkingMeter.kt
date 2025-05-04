package com.igoparking.domain

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

data class ParkingMeter(
    val meterId: String? = null,
    val meterType: String? = null,
    val rateSchedule: List<RateSchedule>? = null,
    val maxTimePeriodPerDays: List<MaxTimePeriodPerDay>? = null,
    val additionalRateInfo: String? = null,
    val meterOperationTime: TimePeriod? = null,
    val additionalTimeInfo: String? = null,
    val isCreditCardAccepted: Boolean? = null,
    val payByPhoneCode: String? = null,
    val location: Geometry? = null,
    val areaName: String? = null,
    val geoPointString: String? = null,
) {
    fun isValidMaxTimePeriod(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Boolean {
        if (startTime.dayOfWeek != endTime.dayOfWeek) {
            throw IllegalArgumentException("Start time and end time must be on the same day.")
        }

        if (endTime.isBefore(startTime)) {
            throw IllegalArgumentException("End time must be after start time.")
        }

        val validMaxTimeDuration =
            this.maxTimePeriodPerDays
                ?.firstOrNull { it.dayOfWeek == startTime.dayOfWeek }
                ?.maxTimePeriodPerHours
                ?.firstOrNull { it.startHour.hour == startTime.hour }
                ?.duration ?: throw IllegalArgumentException("No maximum parking duration found for the specified day and hour.")

        val requestedDuration = Duration.between(startTime, endTime)

        return requestedDuration.toMinutes() <= validMaxTimeDuration.value
    }

    fun calculateRate(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Double {
        // Throws an exception if the start date and end date are different
        // Returns 0 if the end time is earlier than the meter operation start time
        // Returns 0 if the start time is later than the meter operation end time

        // Throws an exception if the time difference between start and end times exceeds MaxTimePeriod
        return 0.0
    }
}

data class MaxTimePeriodPerDay(
    val dayOfWeek: DayOfWeek,
    val maxTimePeriodPerHours: List<MaxTimePeriodPerHour>,
)

data class MaxTimePeriodPerHour(
    val startHour: LocalTime,
    val duration: Minute,
)

data class RateSchedule(
    val ratePerDays: List<RatePerDay>? = null,
)

data class RatePerDay(
    val dayOfWeek: DayOfWeek,
    val ratePerHours: List<RatePerHour>,
)

data class RatePerHour(
    val startHour: LocalTime,
    val rate: Double,
)

data class Geometry(
    val type: String? = null,
    val coordinates: List<Double>? = null,
)

data class Minute(
    val value: Int,
)

data class Dollar(
    val value: Double,
)

data class TimePeriod(
    val startTime: LocalTime,
    val endTime: LocalTime,
)
