package com.igoparking.adapter.out.rds.mapper

import com.igoparking.adapter.out.rds.entity.ContentEntity
import com.igoparking.domain.Content

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
