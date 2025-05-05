package com.igoparking.domain

import com.igoparking.domain.unit.Dollar
import java.time.DayOfWeek
import java.time.LocalTime

data class RateSchedulePerDay(
    val dayOfWeek: DayOfWeek,
    val ratePerHours: List<RatePerHour>,
)

data class RatePerHour(
    val startHour: LocalTime,
    val rate: Dollar,
)
