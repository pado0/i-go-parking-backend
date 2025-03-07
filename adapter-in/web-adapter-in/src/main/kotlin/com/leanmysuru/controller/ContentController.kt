package com.leanmysuru.controller

import com.leanmysuru.domain.Content
import com.leanmysuru.service.ContentService
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
        return ResponseEntity.ok(changed) // what should I return?
    }
}