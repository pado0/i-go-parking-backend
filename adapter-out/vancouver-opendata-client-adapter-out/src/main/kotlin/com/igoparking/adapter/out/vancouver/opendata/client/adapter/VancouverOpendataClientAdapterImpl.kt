package com.igoparking.adapter.out.vancouver.opendata.client.adapter

import LoadParkingMeterPort
import com.igoparking.adapter.out.vancouver.opendata.client.mapper.ParkingMeterMapper
import com.igoparking.adapter.out.vancouver.opendata.client.service.VancouverOpendataClientFeignService
import com.igoparking.domain.ParkingMeter
import org.springframework.stereotype.Service

@Service
class VancouverOpendataClientAdapterImpl(
    private val vancouverOpendataClientFeignService: VancouverOpendataClientFeignService,
) : LoadParkingMeterPort {
    override fun getVancouverOpendataParkingMeters(): List<ParkingMeter>? {
        val response = vancouverOpendataClientFeignService.getParkingMetersCircuitBreaker()
        return if (!response.isOpened) {
            val meters = response.data?.results
            return meters?.map { ParkingMeterMapper.mapToDomainEntity(it) }
        } else {
            null
        }
    }
}
