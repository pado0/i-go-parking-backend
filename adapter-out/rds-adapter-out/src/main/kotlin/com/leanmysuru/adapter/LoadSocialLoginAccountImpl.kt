package com.leanmysuru.adapter

import com.leanmysuru.LoadSocialLoginAccount
import com.leanmysuru.domain.SocialLoginAccount
import com.leanmysuru.mapper.SocialLoginAccountMapper
import com.leanmysuru.repository.SocialLoginAccountRepository
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