package com.igoparking.persistence.port.out

import com.igoparking.domain.ParkingLocation

interface ParkingLocationPersistencePort {
    fun findParkingLocationByLatitudeAndLongitude(
        latitude: Double,
        longitude: Double,
    ): ParkingLocation?
}
