package com.boilterplate.persistence.port.out

import com.igoparking.domain.Content

interface ParkingLocationPersistencePort {
    fun findContentByContentId(contentId: Long): Content?

    fun updateContent(content: Content)
}
