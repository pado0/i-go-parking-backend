package com.boilterplate.api.port.`in`

import com.boilterplate.api.port.`in`.dto.ParkingLocationDto

interface ParkingLocationUsecasePort {
    fun findByLongitudeAndLatitude(
        longitude: Double,
        latitude: Double,
    ): ParkingLocationDto?
}
