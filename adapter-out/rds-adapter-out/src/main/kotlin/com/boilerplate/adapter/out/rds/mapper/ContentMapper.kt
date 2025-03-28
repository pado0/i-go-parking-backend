package com.boilerplate.adapter.out.rds.mapper

import com.boilerplate.adapter.out.rds.entity.ContentEntity
import com.boilerplate.domain.Content

object ContentMapper {
    fun toDomain(entity: ContentEntity?): Content? {
        entity ?: return null
        return with(entity) {
            Content(
                contentId = contentId,
                likedCount = likedCount,
            )
        }
    }
}
