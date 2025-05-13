package com.igoparking.adapter.out.mcp.vancouver.public.client.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ParkingMeterResponse(
    val totalCount: Int,
    val results: List<Meter>,
)

data class Meter(
    val meterhead: String,
    @JsonProperty("r_mf_9a_6p")
    val rMf9a6p: String,
    @JsonProperty("r_mf_6p_10")
    val rMf6p10: String,
    @JsonProperty("r_mf_6p_10")
    val rSa9a6p: String,
    @JsonProperty("r_mf_6p_10")
    val rSa6p10: String,
    @JsonProperty("r_mf_6p_10")
    val rSu9a6p: String,
    @JsonProperty("r_mf_6p_10")
    val rSu6p10: String,
    val rateMisc: String?,
    val timeineffe: String,
    @JsonProperty("r_mf_6p_10")
    val tMf9a6p: String,
    @JsonProperty("r_mf_6p_10")
    val tMf6p10: String,
    @JsonProperty("r_mf_6p_10")
    val tSa9a6p: String,
    @JsonProperty("r_mf_6p_10")
    val tSa6p10: String,
    @JsonProperty("r_mf_6p_10")
    val tSu9a6p: String,
    @JsonProperty("r_mf_6p_10")
    val tSu6p10: String,
    val timeMisc: String?,
    val creditcard: String,
    val pay_phone: String,
    val geom: GeometryWrapper,
    val geoLocalArea: String,
    val meterid: String,
    @JsonProperty("geo_point_2d")
    val geoPoint2d: GeoPoint2D,
)

data class GeometryWrapper(
    val type: String,
    val geometry: Geometry,
    val properties: Map<String, Any>,
)

data class Geometry(
    val coordinates: List<Double>,
    val type: String,
)

data class GeoPoint2D(
    val lon: Double,
    val lat: Double,
)
