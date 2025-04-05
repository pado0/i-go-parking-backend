package com.igoparking.usecase.api.port.`in`

import com.igoparking.usecase.api.port.`in`.dto.ParkingLocationDto

interface ParkingLocationServiceUsecasePort {
    fun findByLongitudeAndLatitude(
        longitude: Double,
        latitude: Double,
    ): ParkingLocationDto?
}
