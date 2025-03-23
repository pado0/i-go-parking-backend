package com.boilerplate.adapter.out.rds.adapter

import com.boilterplate.persistence.port.out.LoadSocialLoginAccount
import com.boilerplate.domain.SocialLoginAccount
import com.boilerplate.adapter.out.rds.mapper.SocialLoginAccountMapper
import com.boilerplate.adapter.out.rds.repository.SocialLoginAccountRepository
import org.springframework.stereotype.Component

@Component
class LoadSocialLoginAccountImpl(
    private val socialLoginAccountRepository: SocialLoginAccountRepository
): LoadSocialLoginAccount {
    override fun findByEmail(email: String): SocialLoginAccount? {
        val entity = socialLoginAccountRepository.findByEmail(email = email)
        return SocialLoginAccountMapper.toDomain(entity)
    }
}