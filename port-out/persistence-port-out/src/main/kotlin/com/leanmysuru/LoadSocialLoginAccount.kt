package com.leanmysuru

import com.leanmysuru.domain.SocialLoginAccount

interface LoadSocialLoginAccount {
    fun findByEmail(email: String): SocialLoginAccount?
}