package com.igoparking.domain

import java.time.DayOfWeek

data class MaxTimePeriodPerDay(
    val dayOfWeek: DayOfWeek,
    val maxTimePeriodPerHours: List<MaxTimePeriodPerHour>,
)
