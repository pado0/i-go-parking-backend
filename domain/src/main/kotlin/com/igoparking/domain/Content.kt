package com.igoparking.domain

data class Content(
    val contentId: Long,
    var likedCount: Long,
) {
    fun increaseLikedCount() {
        this.likedCount += LIKED_COUNT
    }

    fun decreaseLikedCount() {
        if (this.likedCount - LIKED_COUNT < 0) {
            throw Exception()
        }
        this.likedCount -= LIKED_COUNT
    }

    companion object {
        const val LIKED_COUNT = 1L
    }
}
