package com.boilerplate.application.api.service

import com.boilterplate.persistence.port.out.LoadSocialLoginAccount
import com.boilerplate.domain.SocialLoginAccount
import org.springframework.stereotype.Service

@Service
class SocialLoginAccountService(
    private val loadSocialLoginAccount: LoadSocialLoginAccount,
) {
    fun findSocialLoginAccountByEmail(email: String): SocialLoginAccount? {
        return loadSocialLoginAccount.findByEmail(email = email)
    }
}