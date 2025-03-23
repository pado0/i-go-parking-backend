package com.boilerplate.adapter.out.rds.mapper

import com.boilerplate.domain.SocialLoginAccount
import com.boilerplate.adapter.out.rds.entity.SocialLoginAccountEntity

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