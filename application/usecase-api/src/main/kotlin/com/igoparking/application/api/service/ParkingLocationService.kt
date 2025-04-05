package com.igoparking.application.api.service

import com.igoparking.persistence.port.out.ParkingLocationPersistencePort
import com.igoparking.usecase.api.port.`in`.ParkingLocationServiceUsecasePort
import com.igoparking.usecase.api.port.`in`.dto.ParkingLocationDto
import org.springframework.stereotype.Service

@Service
class ParkingLocationService(
    private val parkingLocationPersistencePort: ParkingLocationPersistencePort,
) : ParkingLocationServiceUsecasePort {
    override fun findByLongitudeAndLatitude(
        longitude: Double,
        latitude: Double,
    ): ParkingLocationDto {
        parkingLocationPersistencePort.findParkingLocationByLatitudeAndLongitude(latitude, longitude)
        return ParkingLocationDto(12.0, 12.0)
    }
}
