import com.igoparking.domain.ParkingMeter

interface LoadParkingMeterPort {
    fun getVancouverOpendataParkingMeters(): List<ParkingMeter>?
}
