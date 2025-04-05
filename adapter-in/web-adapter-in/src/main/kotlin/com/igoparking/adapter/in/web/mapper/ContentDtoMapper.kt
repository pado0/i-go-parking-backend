package com.igoparking.adapter.`in`.web.mapper

import com.igoparking.adapter.`in`.web.dto.response.ContentResponse
import com.boilterplate.api.port.`in`.dto.ContentDto

object ContentDtoMapper {
    fun toResponse(contentDto: ContentDto): ContentResponse =
        ContentResponse(
            contentId = contentDto.contentId,
            likedCount = contentDto.likedCount,
        )
}
