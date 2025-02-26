package com.leanmysuru.controller

import com.leanmysuru.domain.AuthAccount
import com.leanmysuru.service.AuthAccountService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class AuthAccountController(
    private val authAccountService: AuthAccountService,
) {
    @GetMapping("/auth/{email}")
    fun getAuthAccount(@PathVariable email: String): AuthAccount? {
        return authAccountService.findAuthAccountByEmail(email)
    }
}