package com.leanmysuru.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class AuthAccountEntity(
    @Column(nullable = false, unique = true)
    val email: String,
    val name: String,
    val profileImageUrl: String,
) {
    @Id
    val authAccountId: Long = 0L
}