package com.leanmysuru.service

import com.leanmysuru.ContentPersistencePort
import com.leanmysuru.domain.Content
import org.springframework.stereotype.Service

@Service
class ContentService(
    private val contentPersistencePort: ContentPersistencePort,
) {
    fun decreaseLikedCount(contentId: Long, count: Long): Content? {
        // this is domain. so persistence context is not working
        // I have to re-persist it at the update function
        val content = contentPersistencePort.findContentByContentId(contentId = contentId)

        content?.decreaseLikedCount(count = count)
            ?: return Content(contentId, 0)

        contentPersistencePort.updateContent(content = content)
        return content
    }
}