package com.igoparking.adapter.out.mcp.vancouver.public.client.service

import com.igoparking.adapter.out.feign.circuit.circuit
import com.igoparking.adapter.out.feign.circuit.fallback
import com.igoparking.adapter.out.feign.dto.CircuitBreakerResult
import com.igoparking.adapter.out.mcp.vancouver.public.client.client.VancouverPublicClient
import com.igoparking.adapter.out.mcp.vancouver.public.client.dto.ParkingMeterResponse
import org.springframework.stereotype.Component

@Component
class VancouverPublicClientFeignService(
    private val vancouverPublicClient: VancouverPublicClient,
) {
    fun getParkingMetersCircuitBreaker(bearerToken: String): CircuitBreakerResult<ParkingMeterResponse?> =
        circuit(name = "vancouver-public-client") {
            CircuitBreakerResult(
                data = vancouverPublicClient.getParkingMeters(bearerToken).data,
                isOpened = false,
            )
        }.fallback {
            CircuitBreakerResult(data = null, isOpened = true)
        }.getOrThrow()
}
