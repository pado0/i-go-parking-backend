package com.igoparking.adapter.out.rds.adapter

import com.igoparking.adapter.out.rds.repository.ContentRepository
import com.igoparking.domain.ParkingLocation
import com.igoparking.persistence.port.out.ParkingLocationPersistencePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
@Transactional
class ParkingLocationPersistencePortImpl(
    private val contentRepository: ContentRepository,
) : ParkingLocationPersistencePort {
    override fun findParkingLocationByLatitudeAndLongitude(
        latitude: Double,
        longitude: Double,
    ): ParkingLocation? = ParkingLocation(10.1, 10.1)
}
