package com.boilerplate.adapter.`in`.web.controller

import com.boilerplate.domain.SocialLoginAccount
import com.boilerplate.application.api.service.SocialLoginAccountService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class SocialLoginAccountController(
    private val socialLoginAccountService: SocialLoginAccountService,
) {
    @GetMapping("/auth/{email}")
    fun getSocialLoginAccount(@PathVariable email: String): SocialLoginAccount? {
        // todo: [boilerplate] define response format
        return socialLoginAccountService.findSocialLoginAccountByEmail(email)
    }
}