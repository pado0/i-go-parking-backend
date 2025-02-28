package com.leanmysuru.service

import com.leanmysuru.LoadSocialLoginAccount
import com.leanmysuru.domain.SocialLoginAccount
import org.springframework.stereotype.Service

@Service
class SocialLoginAccountService(
    private val loadSocialLoginAccount: LoadSocialLoginAccount,
) {
    fun findSocialLoginAccountByEmail(email: String): SocialLoginAccount? {
        return loadSocialLoginAccount.findByEmail(email = email)
    }
}