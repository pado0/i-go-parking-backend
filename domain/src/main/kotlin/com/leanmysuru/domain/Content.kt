package com.leanmysuru.domain

data class Content(
    val contentId: Long,
    var likedCount: Long,
){
    fun decreaseLikedCount(count: Long) {
        if(count <= 0){
            throw Exception()
        }
        if (this.likedCount - count < 0 ){
            throw Exception()
        }
        this.likedCount -= count
    }
}