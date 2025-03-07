package com.leanmysuru

import com.leanmysuru.domain.Content

interface ContentPersistencePort {
    fun findContentByContentId(contentId: Long): Content?
    fun updateContent(content: Content)
}