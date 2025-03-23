package com.boilterplate.persistence.port.out

import com.boilerplate.domain.Content

interface ContentPersistencePort {
    fun findContentByContentId(contentId: Long): Content?
    fun updateContent(content: Content)
}