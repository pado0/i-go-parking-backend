package com.boilterplate.api.port.`in`

import com.boilterplate.api.port.`in`.dto.ContentDto

interface ContentUsecasePort {
    fun increaseLikedCount(contentId: Long): ContentDto?

    fun decreaseLikedCount(contentId: Long): ContentDto?
}
