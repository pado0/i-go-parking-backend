package com.boilerplate.adapter.`in`.web.controller

import com.boilerplate.domain.Content
import com.boilerplate.application.api.service.ContentService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ContentController(
    private val contentService: ContentService,
) {
    @DeleteMapping("/{contentId}/liked")
    fun decreaseLikedCount(
        @PathVariable contentId: Long,
        @RequestParam count: Long,
    ): ResponseEntity<Content?> {
        val changed = contentService.decreaseLikedCount(
            contentId = contentId,
            count = count,
        )
        return ResponseEntity.ok(changed)
    }
}