package com.boilerplate.adapter.`in`.web.mapper

import com.boilerplate.adapter.`in`.web.dto.response.ContentResponse
import com.boilterplate.api.port.`in`.dto.ContentDto

object ContentDtoMapper {
    fun toResponse(contentDto: ContentDto): ContentResponse =
        ContentResponse(
            contentId = contentDto.contentId,
            likedCount = contentDto.likedCount,
        )
}
