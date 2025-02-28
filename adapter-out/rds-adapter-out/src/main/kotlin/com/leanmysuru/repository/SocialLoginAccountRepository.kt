package com.leanmysuru.repository

import com.leanmysuru.entity.SocialLoginAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SocialLoginAccountRepository : JpaRepository<SocialLoginAccountEntity, Long> {
    fun findByEmail(email: String): SocialLoginAccountEntity?
}