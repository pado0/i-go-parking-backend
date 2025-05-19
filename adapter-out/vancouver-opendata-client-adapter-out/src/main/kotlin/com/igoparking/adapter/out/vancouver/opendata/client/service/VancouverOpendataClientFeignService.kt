package com.igoparking.adapter.out.vancouver.opendata.client.service

import com.igoparking.adapter.out.feign.circuit.circuit
import com.igoparking.adapter.out.feign.circuit.fallback
import com.igoparking.adapter.out.feign.dto.CircuitBreakerResult
import com.igoparking.adapter.out.vancouver.opendata.client.client.VancouverOpendataClient
import com.igoparking.adapter.out.vancouver.opendata.client.dto.ParkingMeterResponse
import org.springframework.stereotype.Component

@Component
class VancouverOpendataClientFeignService(
    private val vancouverOpendataClient: VancouverOpendataClient,
) {
    fun getParkingMetersCircuitBreaker(): CircuitBreakerResult<ParkingMeterResponse?> =
        circuit(name = "vancouver-opendata-client") {
            CircuitBreakerResult(
                data = vancouverOpendataClient.getParkingMeters(),
                isOpened = false,
            )
        }.fallback {
            CircuitBreakerResult(data = null, isOpened = true)
        }.getOrThrow()
}
