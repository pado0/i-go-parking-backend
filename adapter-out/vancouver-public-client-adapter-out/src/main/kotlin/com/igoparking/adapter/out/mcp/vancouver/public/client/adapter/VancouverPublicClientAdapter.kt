package com.igoparking.adapter.out.mcp.vancouver.public.client.adapter

import com.igoparking.adapter.out.mcp.vancouver.public.client.dto.ParkingMeterResponse

interface VancouverPublicClientAdapter {
    fun getParkingMeters(bearerToken: String): ParkingMeterResponse?
}
