package com.leanmysuru.mapper

import com.leanmysuru.domain.AuthAccount
import com.leanmysuru.entity.AuthAccountEntity

object AuthAccountMapper {
    fun toDomain(entity: AuthAccountEntity?): AuthAccount? {
        entity ?: return null
        return with(entity) {
            AuthAccount(
                email = email,
            )
        }
    }
}