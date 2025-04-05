package com.igoparking.usecase.api.port.`in`

import com.igoparking.usecase.api.port.`in`.dto.ParkingLocationDto

interface ParkingLocationToolUsecasePort {
    fun getByLongitudeAndLatitude(
        longitude: Double,
        latitude: Double,
    ): ParkingLocationDto?
}
