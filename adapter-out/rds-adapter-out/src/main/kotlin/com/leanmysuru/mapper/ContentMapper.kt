package com.leanmysuru.mapper

import com.leanmysuru.domain.Content
import com.leanmysuru.entity.ContentEntity

object ContentMapper {
    fun toDomain(entity: ContentEntity?): Content? {
        entity ?: return null
        return with(entity) {
            Content(
                contentId = contentId,
                likedCount = likedCount
            )
        }
    }
}