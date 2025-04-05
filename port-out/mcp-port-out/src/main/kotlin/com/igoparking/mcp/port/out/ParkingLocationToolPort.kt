package com.igoparking.mcp.port.out

import com.igoparking.domain.ParkingLocation

interface ParkingLocationToolPort {
    fun getNearestParkingLocations(
        latitude: Double,
        longitude: Double,
    ): ParkingLocation
}
