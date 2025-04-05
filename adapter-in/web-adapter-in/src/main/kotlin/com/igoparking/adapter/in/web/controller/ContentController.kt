package com.igoparking.adapter.`in`.web.controller

import com.boilterplate.api.port.`in`.ParkingLocationUsecasePort
import org.springframework.stereotype.Controller

@Controller
class ContentController(
    private val parkingLocationUsecasePort: ParkingLocationUsecasePort,
) {
//    @PostMapping("/{contentId}/liked")
//    fun increaseLikedCount(
//        @PathVariable contentId: Long,
//    ): Response<ContentResponse> {
//        val changed =
//            parkingLocationUsecasePort.findByLongitudeAndLatitude(
//                longitude = 10.0,
//                latitude = 10.0,
//            )
//        return Response(changed?.let { ContentDtoMapper.toResponse(parkingLocationDto = changed) })
//    }
}
