package com.igoparking.domain

import java.time.Duration
import java.time.LocalDateTime

data class ParkingMeter(
    val meterId: String? = null,
    val meterType: String? = null,
    val rateSchedulePerDays: List<RateSchedulePerDay>? = null,
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
                ?.duration
                ?: return true // no limitation

        val requestedDuration = Duration.between(startTime, endTime)

        return requestedDuration.toMinutes() <= validMaxTimeDuration.value
    }

    fun calculateRate(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Double {
        require(isValidMaxTimePeriod(startTime, endTime)) {
            "Max time period must be valid."
        }

        val startHour = startTime.toLocalTime().hour
        val endHour = endTime.toLocalTime().hour
        val startMinute = startTime.toLocalTime().minute
        val endMinute = endTime.toLocalTime().minute

        val ratePerHours =
            rateSchedulePerDays
                ?.firstOrNull { it.dayOfWeek == startTime.dayOfWeek }
                ?.ratePerHours
                ?.filter { it.startHour.hour in startHour..endHour }
                ?: return 0.0

        // Case: same hour → partial minute billing only
        if (startHour == endHour) {
            val minutesUsed = endMinute - startMinute
            return ratePerHours
                .firstOrNull()
                ?.rate
                ?.value
                ?.div(MINUTES_60)
                ?.times(minutesUsed) ?: 0.0
        }

        // Case: multi-hour
        return ratePerHours.sumOf { ratePerHour ->
            val hour = ratePerHour.startHour.hour
            val ratePerMinute = ratePerHour.rate.value / MINUTES_60

            when (hour) {
                startHour -> ratePerMinute * (60 - startMinute)
                endHour -> ratePerMinute * endMinute
                else -> ratePerHour.rate.value
            }
        }
    }

    companion object {
        private const val MINUTES_60 = 60.0
    }
}
