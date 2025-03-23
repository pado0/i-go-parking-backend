package com.boilerplate.adapter.out.rds.mapper

import com.boilerplate.domain.Content
import com.boilerplate.adapter.out.rds.entity.ContentEntity

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