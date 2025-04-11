package com.igoparking.domain

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

data class ParkingMeter(
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
    val meterId: String? = null,
    val geoPointString: String? = null,
) {
    fun isValidMaxTimePeriod(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Boolean {
        if (startTime.dayOfWeek != endTime.dayOfWeek) {
            throw Exception()
        }

        if (endTime.isBefore(startTime)) {
            throw Exception()
        }

        val validMaxTimeDuration =
            this.maxTimePeriodPerDays
                ?.firstOrNull { it.dayOfWeek == startTime.dayOfWeek }
                ?.maxTimePeriodPerHours
                ?.firstOrNull { it.startHour.hour == startTime.hour }
                ?.duration ?: throw Exception()

        val requestedDuration = Duration.between(startTime, endTime)

        return requestedDuration.toMinutes() <= validMaxTimeDuration.value
    }

    fun calculateRate(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): Double {
        // 시작시간과 끝나는 시간의 날짜가 다른 경우 예외를 반환한다.
        // 끝나는 시간이 Meter operator 시작시간보다 빠르면 0원을 반환한다.
        // 시작시간이 Meter operator 끝나는 시간보다 느리면 0원을 반환한다.

        // 시작시간과 끝나는 시간의 차이가 MaxTimePeriod를 넘어가면 예외를 반환한다.
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
