package com.igoparking.domain

import java.time.LocalTime

data class TimePeriod(
    val startTime: LocalTime,
    val endTime: LocalTime,
)
