package com.igoparking

import LoadParkingMeterPort
import com.igoparking.domain.ParkingMeter
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SpringBootTestApplication::class])
class VancouverOpendataIntegrationTest(
    private val loadParkingMeterPort: LoadParkingMeterPort,
) : StringSpec({
        "get parking meters with circuit breaker" {
            val parkingMeter: List<ParkingMeter>? =
                loadParkingMeterPort
                    .getVancouverOpendataParkingMeters()

            parkingMeter shouldNotBe null
        }
    })
