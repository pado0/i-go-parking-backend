package com.igoparking.adapter.out.rds.repository

import com.igoparking.adapter.out.rds.entity.ContentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentRepository : JpaRepository<ContentEntity, Long> {
    fun findContentEntityByContentId(contentId: Long): ContentEntity?
}
