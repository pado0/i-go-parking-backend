package com.boilterplate.persistence.port.out

import com.boilerplate.domain.SocialLoginAccount

interface LoadSocialLoginAccount {
    fun findByEmail(email: String): SocialLoginAccount?
}