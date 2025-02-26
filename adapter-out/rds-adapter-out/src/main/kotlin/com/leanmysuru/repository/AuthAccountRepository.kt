package com.leanmysuru.repository

import com.leanmysuru.entity.AuthAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthAccountRepository : JpaRepository<AuthAccountEntity, Long> {
    fun findByEmail(email: String): AuthAccountEntity?
}