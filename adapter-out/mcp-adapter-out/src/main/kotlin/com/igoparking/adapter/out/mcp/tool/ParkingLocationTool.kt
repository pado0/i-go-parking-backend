package com.igoparking.adapter.out.mcp.tool

import com.boilterplate.api.port.`in`.ParkingLocationUsecasePort
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Service

@Service
class ParkingLocationTool(
    private val parkingLocationUsecasePort: ParkingLocationUsecasePort,
) {
    @Tool(description = "Get nearest parking locations")
    fun getNearestParkingLocations(
        @ToolParam(description = "The latitude information") latitude: Double,
        @ToolParam(description = "The longitude  information") longitude: Double,
    ) = parkingLocationUsecasePort.findByLongitudeAndLatitude(
        latitude = latitude,
        longitude = longitude,
    )
}
