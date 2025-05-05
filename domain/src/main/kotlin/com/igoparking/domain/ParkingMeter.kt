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

        if (endTime.toLocalTime().isAfter(meterOperationTime?.endTime)) {
            throw IllegalArgumentException("Meter Operation End time must be after end time.")
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
        if (!isValidMaxTimePeriod(startTime, endTime)) throw IllegalArgumentException("Max time period must be valid.")

        val ratePerHours: List<RatePerHour>? =
            this.rateSchedule
                ?.firstOrNull { it.dayOfWeek == startTime.dayOfWeek }
                ?.ratePerHours
                ?.filter { it.startHour.hour in startTime.toLocalTime().hour..endTime.toLocalTime().hour }

        var totalRate = 0.0
        ratePerHours?.forEach { ratePerHour ->
            val ratePerMinute = ratePerHour.rate.value / 60.0

            if (startTime.hour == endTime.hour) {
                val startMinute = endTime.toLocalTime().minute - startTime.toLocalTime().minute
                return ratePerMinute * startMinute
            }

            if (startTime.hour == ratePerHour.startHour.hour) {
                val rateMinute = 60 - startTime.toLocalTime().minute
                totalRate += ratePerMinute * rateMinute
            } else if (endTime.hour == ratePerHour.startHour.hour) {
                val rateMinute = endTime.toLocalTime().minute
                totalRate += ratePerMinute * rateMinute
            } else {
                totalRate += ratePerHour.rate.value
            }
        }

        return totalRate
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
    val dayOfWeek: DayOfWeek,
    val ratePerHours: List<RatePerHour>,
)

data class RatePerHour(
    val startHour: LocalTime,
    val rate: Dollar,
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
