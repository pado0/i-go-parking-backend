package com.igoparking.adapter.out.rds.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "content")
class ContentEntity(
    var likedCount: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val contentId: Long = 0L
}
