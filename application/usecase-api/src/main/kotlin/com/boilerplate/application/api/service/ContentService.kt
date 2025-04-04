package com.boilerplate.application.api.service

import com.boilterplate.api.port.`in`.ContentUsecasePort
import com.boilterplate.api.port.`in`.dto.ContentDto
import com.boilterplate.api.port.`in`.mapper.ContentMapper
import com.boilterplate.persistence.port.out.ContentPersistencePort
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class ContentService(
    private val contentPersistencePort: ContentPersistencePort,
) : ContentUsecasePort {
    override fun increaseLikedCount(contentId: Long): ContentDto? {
        val content = contentPersistencePort.findContentByContentId(contentId = contentId)
        content?.increaseLikedCount() ?: return ContentDto(contentId, 0)

        logger.info { "[Sample Log] Increased liked count for content $contentId" }
        contentPersistencePort.updateContent(content = content)
        return ContentMapper.toDto(content = content)
    }

    override fun decreaseLikedCount(contentId: Long): ContentDto? {
        val content = contentPersistencePort.findContentByContentId(contentId = contentId)
        content?.decreaseLikedCount() ?: return ContentDto(contentId, 0)

        contentPersistencePort.updateContent(content = content)
        return ContentMapper.toDto(content = content)
    }
}
