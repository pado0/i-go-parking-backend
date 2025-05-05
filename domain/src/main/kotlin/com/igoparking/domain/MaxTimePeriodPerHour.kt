package com.igoparking.domain

import com.igoparking.domain.unit.Minute
import java.time.LocalTime

data class MaxTimePeriodPerHour(
    val startHour: LocalTime,
    val duration: Minute,
)
