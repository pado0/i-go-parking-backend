package com.igoparking.domain

data class ParkingLocation(
    val altitude: Double,
    var longitude: Double,
) {
    fun increaseLikedCount() {
        this.longitude += LIKED_COUNT
    }

    fun decreaseLikedCount() {
        if (this.longitude - LIKED_COUNT < 0) {
            throw Exception()
        }
        this.longitude -= LIKED_COUNT
    }

    companion object {
        const val LIKED_COUNT = 1L
    }
}
