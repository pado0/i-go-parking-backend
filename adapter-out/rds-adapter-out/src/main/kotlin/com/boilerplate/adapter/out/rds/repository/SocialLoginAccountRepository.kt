package com.boilerplate.adapter.out.rds.repository

import com.boilerplate.adapter.out.rds.entity.SocialLoginAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SocialLoginAccountRepository : JpaRepository<SocialLoginAccountEntity, Long> {
    fun findByEmail(email: String): SocialLoginAccountEntity?
}