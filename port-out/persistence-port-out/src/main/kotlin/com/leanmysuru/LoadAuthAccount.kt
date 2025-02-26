package com.leanmysuru

import com.leanmysuru.domain.AuthAccount

interface LoadAuthAccount {
    fun findByEmail(email: String): AuthAccount?
}