package com.igoparking.adapter.out.vancouver.opendata.client.client

import com.igoparking.adapter.out.feign.config.FeignConfig
import com.igoparking.adapter.out.vancouver.opendata.client.dto.ParkingMeterResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.retry.annotation.Retryable
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "vancouver-opendata-client",
    url = "\${client.vancouver-opendata.host}",
    configuration = [FeignConfig::class],
)
interface VancouverOpendataClient {
    @Retryable(maxAttempts = 2)
    @GetMapping("/api/explore/v2.1/catalog/datasets/parking-meters/records")
    fun getParkingMeters(): ParkingMeterResponse
}
