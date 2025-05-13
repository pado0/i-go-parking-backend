package com.igoparking.adapter.out.vancouver.public.client.dto

data class ParkingMeterResponse(
    val total_count: Int,
    val results: List<Meter>,
)

data class Meter(
    val meterhead: String,
    val r_mf_9a_6p: String,
    val r_mf_6p_10: String,
    val r_sa_9a_6p: String,
    val r_sa_6p_10: String,
    val r_su_9a_6p: String,
    val r_su_6p_10: String,
    val rate_misc: String?,
    val timeineffe: String,
    val t_mf_9a_6p: String,
    val t_mf_6p_10: String,
    val t_sa_9a_6p: String,
    val t_sa_6p_10: String,
    val t_su_9a_6p: String,
    val t_su_6p_10: String,
    val time_misc: String?,
    val creditcard: String,
    val pay_phone: String,
    val geom: GeometryWrapper,
    val geo_local_area: String,
    val meterid: String,
    val geo_point_2d: GeoPoint2D,
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
