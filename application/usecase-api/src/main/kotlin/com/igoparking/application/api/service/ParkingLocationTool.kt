package com.igoparking.application.api.service

import com.igoparking.mcp.port.out.ParkingLocationToolPort
import com.igoparking.usecase.api.port.`in`.ParkingLocationToolUsecasePort
import com.igoparking.usecase.api.port.`in`.dto.ParkingLocationDto
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class ParkingLocationTool(
    private val parkingLocationToolPort: ParkingLocationToolPort,
) : ParkingLocationToolUsecasePort {
    override fun getByLongitudeAndLatitude(
        longitude: Double,
        latitude: Double,
    ): ParkingLocationDto {
        val domain = parkingLocationToolPort.getNearestParkingLocations(latitude, longitude)
        return ParkingLocationDto(domain.altitude, domain.longitude)
    }
}
