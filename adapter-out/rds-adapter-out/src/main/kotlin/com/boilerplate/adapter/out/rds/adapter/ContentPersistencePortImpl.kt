package com.boilerplate.adapter.out.rds.adapter

import com.boilerplate.adapter.out.rds.mapper.ContentMapper
import com.boilerplate.adapter.out.rds.repository.ContentRepository
import com.boilerplate.domain.Content
import com.boilterplate.persistence.port.out.ContentPersistencePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
@Transactional
class ContentPersistencePortImpl(
    private val contentRepository: ContentRepository,
) : ContentPersistencePort {
    override fun findContentByContentId(contentId: Long): Content? {
        val entity = contentRepository.findContentEntityByContentId(contentId = contentId)
        return ContentMapper.toDomain(entity)
    }

    override fun updateContent(content: Content) {
        val entity = contentRepository.findContentEntityByContentId(contentId = content.contentId)
        entity?.likedCount = content.likedCount
        contentRepository.save(entity)
    }
}
