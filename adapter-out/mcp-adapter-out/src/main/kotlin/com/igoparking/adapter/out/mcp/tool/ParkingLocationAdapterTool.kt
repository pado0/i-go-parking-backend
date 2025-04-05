package com.igoparking.adapter.out.mcp.tool

import com.igoparking.domain.ParkingLocation
import com.igoparking.mcp.port.out.ParkingLocationToolPort
import com.igoparking.usecase.api.port.`in`.ParkingLocationServiceUsecasePort
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Service

@Service
class ParkingLocationAdapterTool(
    private val parkingLocationServiceUsecasePort: ParkingLocationServiceUsecasePort,
) : ParkingLocationToolPort {
    @Tool(description = "Get nearest parking locations")
    @Override
    override fun getNearestParkingLocations(
        @ToolParam(description = "The latitude information") latitude: Double,
        @ToolParam(description = "The longitude  information") longitude: Double,
    ): ParkingLocation {
        parkingLocationServiceUsecasePort.findByLongitudeAndLatitude(10.1, 10.1)
        return ParkingLocation(10.1, 10.1)
    }
}
