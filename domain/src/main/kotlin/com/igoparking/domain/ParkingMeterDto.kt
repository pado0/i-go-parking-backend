data class ParkingMeter(
    val meterHead: String? = null,
    val rateMf9a6p: Double? = null,
    val rateMf6p10: Double? = null,
    val rateSa9a6p: Double? = null,
    val rateSa6p10: Double? = null,
    val rateSu9a6p: Double? = null,
    val rateSu6p10: Double? = null,
    val rateMisc: String? = null,
    val timeInEffect: String? = null,
    val timeMf9a6p: String? = null,
    val timeMf6p10: String? = null,
    val timeSa9a6p: String? = null,
    val timeSa6p10: String? = null,
    val timeSu9a6p: String? = null,
    val timeSu6p10: String? = null,
    val timeMisc: String? = null,
    val creditCard: Boolean? = null,
    val payPhone: String? = null,
    val geom: Geometry? = null,
    val geoLocalArea: String? = null,
    val meterId: String? = null,
    val geoPoint2d: String? = null,
)

data class Geometry(
    val type: String? = null,
    val coordinates: List<Double>? = null, // [longitude, latitude]
)
