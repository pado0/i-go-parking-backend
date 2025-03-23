package com.boilerplate.application.api.service

import com.boilterplate.persistence.port.out.ContentPersistencePort
import com.boilerplate.domain.Content
import org.springframework.stereotype.Service

@Service
class ContentService(
    private val contentPersistencePort: ContentPersistencePort,
) {
    fun decreaseLikedCount(contentId: Long, count: Long): Content? {
        val content = contentPersistencePort.findContentByContentId(contentId = contentId)

        content?.decreaseLikedCount(count = count)
            ?: return Content(contentId, 0)

        contentPersistencePort.updateContent(content = content)
        return content
    }
}