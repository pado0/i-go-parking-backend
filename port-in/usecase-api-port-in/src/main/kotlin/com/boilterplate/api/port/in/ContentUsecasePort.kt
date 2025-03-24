package com.boilterplate.api.port.`in`

import com.boilerplate.domain.Content


interface ContentUsecasePort {
    fun decreaseLikedCount(contentId: Long, count: Long): Content?
}