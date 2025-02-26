package com.leanmysuru.adapter

import com.leanmysuru.LoadAuthAccount
import com.leanmysuru.domain.AuthAccount
import com.leanmysuru.mapper.AuthAccountMapper
import com.leanmysuru.repository.AuthAccountRepository
import org.springframework.stereotype.Component

@Component
class LoadAuthAccountImpl(
    private val authAccountRepository: AuthAccountRepository
): LoadAuthAccount {
    override fun findByEmail(email: String): AuthAccount? {
        val entity = authAccountRepository.findByEmail(email = email)
        return AuthAccountMapper.toDomain(entity)
    }
}