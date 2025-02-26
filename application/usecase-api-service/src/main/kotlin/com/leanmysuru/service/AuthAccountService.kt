package com.leanmysuru.service

import com.leanmysuru.LoadAuthAccount
import com.leanmysuru.domain.AuthAccount
import org.springframework.stereotype.Service

@Service
class AuthAccountService(
    private val loadAuthAccount: LoadAuthAccount,
) {
    fun findAuthAccountByEmail(email: String): AuthAccount? {
        return loadAuthAccount.findByEmail(email = email)
    }
}