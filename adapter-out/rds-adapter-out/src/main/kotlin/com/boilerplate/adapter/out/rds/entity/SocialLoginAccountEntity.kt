package com.boilerplate.adapter.out.rds.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "social_login_account")
data class SocialLoginAccountEntity(
    @Column(nullable = false, unique = true)
    val email: String,
    val name: String,
    val profileImageUrl: String,
) {
    @Id
    val socialLoginAccountId: Long = 0L
}