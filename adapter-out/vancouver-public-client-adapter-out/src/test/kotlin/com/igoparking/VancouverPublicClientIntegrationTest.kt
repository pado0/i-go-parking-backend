package com.igoparking

import com.igoparking.adapter.out.vancouver.public.client.adapter.VancouverPublicClientAdapter
import com.igoparking.adapter.out.vancouver.public.client.dto.ParkingMeterResponse
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SpringBootTestApplication::class])
class VancouverPublicClientIntegrationTest(
    private val vancouverPublicClientAdapter: VancouverPublicClientAdapter,
) : StringSpec({
        "get parking meters with circuit breaker" {
            val parkingMeter: ParkingMeterResponse? =
                vancouverPublicClientAdapter
                    .getParkingMeters("vancouver-public-client")

            parkingMeter shouldNotBe null
        }
    })
