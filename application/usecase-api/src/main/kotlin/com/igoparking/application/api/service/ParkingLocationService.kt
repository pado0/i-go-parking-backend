package com.igoparking.application.api.service

import com.boilterplate.api.port.`in`.ParkingLocationUsecasePort
import com.boilterplate.api.port.`in`.dto.ParkingLocationDto
import com.boilterplate.persistence.port.out.ParkingLocationPersistencePort
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class ParkingLocationService(
    private val parkingLocationPersistencePort: ParkingLocationPersistencePort,
) : ParkingLocationUsecasePort {
    override fun findByLongitudeAndLatitude(
        longitude: Double,
        latitude: Double,
    ): ParkingLocationDto = ParkingLocationDto(10.0, 10.0)
}
