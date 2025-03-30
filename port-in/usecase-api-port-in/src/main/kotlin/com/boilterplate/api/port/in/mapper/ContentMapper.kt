package com.boilterplate.api.port.`in`.mapper

import com.boilerplate.domain.Content
import com.boilterplate.api.port.`in`.dto.ContentDto

object ContentMapper {
    fun toDto(content: Content): ContentDto =
        ContentDto(
            contentId = content.contentId,
            likedCount = content.likedCount,
        )
}
