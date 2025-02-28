package com.leanmysuru.mapper

import com.leanmysuru.domain.SocialLoginAccount
import com.leanmysuru.entity.SocialLoginAccountEntity

object SocialLoginAccountMapper {
    fun toDomain(entity: SocialLoginAccountEntity?): SocialLoginAccount? {
        entity ?: return null
        return with(entity) {
            SocialLoginAccount(
                email = email,
            )
        }
    }
}