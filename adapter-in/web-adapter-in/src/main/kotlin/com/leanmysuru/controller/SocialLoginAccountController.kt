package com.leanmysuru.controller

import com.leanmysuru.domain.SocialLoginAccount
import com.leanmysuru.service.SocialLoginAccountService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class SocialLoginAccountController(
    private val socialLoginAccountService: SocialLoginAccountService,
) {
    @GetMapping("/auth/{email}")
    fun getSocialLoginAccount(@PathVariable email: String): SocialLoginAccount? {
        return socialLoginAccountService.findSocialLoginAccountByEmail(email)
    }
}