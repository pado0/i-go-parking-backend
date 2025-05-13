package com.igoparking.adapter.out.vancouver.public.client.client

import com.igoparking.adapter.out.feign.config.FeignConfig
import com.igoparking.adapter.out.vancouver.public.client.dto.ParkingMeterResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.retry.annotation.Retryable
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "vancouver-public-client",
    url = "\${client.vancouver-public.host}",
    configuration = [FeignConfig::class],
)
interface VancouverPublicClient {
    @Retryable(maxAttempts = 2)
    @GetMapping("/api/explore/v2.1/catalog/datasets/parking-meters/records")
    fun getParkingMeters(): ParkingMeterResponse
}
