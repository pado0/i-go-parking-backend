package com.igoparking.adapter.out.vancouver.public.client.adapter

import com.igoparking.adapter.out.vancouver.public.client.dto.ParkingMeterResponse

interface VancouverPublicClientAdapter {
    fun getParkingMeters(bearerToken: String): ParkingMeterResponse?
}
