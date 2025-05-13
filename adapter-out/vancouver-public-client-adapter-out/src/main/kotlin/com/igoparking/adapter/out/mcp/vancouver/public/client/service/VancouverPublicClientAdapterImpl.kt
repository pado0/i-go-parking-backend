package com.igoparking.adapter.out.mcp.vancouver.public.client.service

import com.igoparking.adapter.out.mcp.vancouver.public.client.adapter.VancouverPublicClientAdapter
import com.igoparking.adapter.out.mcp.vancouver.public.client.dto.ParkingMeterResponse
import org.springframework.stereotype.Service

@Service
class VancouverPublicClientAdapterImpl(
    private val vancouverPublicClientFeignService: VancouverPublicClientFeignService,
) : VancouverPublicClientAdapter {
    override fun getParkingMeters(bearerToken: String): ParkingMeterResponse? {
        val response = vancouverPublicClientFeignService.getParkingMetersCircuitBreaker(bearerToken)
        return if (!response.isOpened) {
            return response.data
        } else {
            null
        }
    }
}
