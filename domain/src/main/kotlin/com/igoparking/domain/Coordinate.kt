package com.igoparking.domain

import com.igoparking.domain.unit.Degree

data class Coordinate(
    val longitude: Degree,
    val latitude: Degree,
)
