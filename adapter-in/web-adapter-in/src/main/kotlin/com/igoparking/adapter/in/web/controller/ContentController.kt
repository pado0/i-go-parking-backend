package com.igoparking.adapter.`in`.web.controller

import com.igoparking.adapter.`in`.common.response.Response
import com.igoparking.adapter.`in`.web.dto.response.ContentResponse
import com.igoparking.adapter.`in`.web.mapper.ContentDtoMapper
import com.boilterplate.api.port.`in`.ContentUsecasePort
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ContentController(
    private val contentUsecasePort: ContentUsecasePort,
) {
    @PostMapping("/{contentId}/liked")
    fun increaseLikedCount(
        @PathVariable contentId: Long,
    ): Response<ContentResponse> {
        val changed = contentUsecasePort.increaseLikedCount(contentId = contentId)
        return Response(changed?.let { ContentDtoMapper.toResponse(contentDto = changed) })
    }

    @DeleteMapping("/{contentId}/liked")
    fun decreaseLikedCount(
        @PathVariable contentId: Long,
    ): Response<ContentResponse> {
        val changed = contentUsecasePort.decreaseLikedCount(contentId = contentId)
        return Response(changed?.let { ContentDtoMapper.toResponse(contentDto = changed) })
    }
}
