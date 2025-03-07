package com.leanmysuru.domain

data class Content(
    val contentId: Long,
    var likedCount: Long,
){
    fun decreaseLikedCount(count: Long) {
        this.likedCount -= count
    }
}