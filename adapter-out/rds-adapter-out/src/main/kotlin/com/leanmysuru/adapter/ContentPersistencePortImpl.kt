package com.leanmysuru.adapter

import com.leanmysuru.ContentPersistencePort
import com.leanmysuru.domain.Content
import com.leanmysuru.mapper.ContentMapper
import com.leanmysuru.repository.ContentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
@Transactional
class ContentPersistencePortImpl(
    private val contentRepository: ContentRepository
) : ContentPersistencePort {
    override fun findContentByContentId(contentId: Long): Content? {
        val entity = contentRepository.findContentEntityByContentId(contentId = contentId)
        return ContentMapper.toDomain(entity)
    }

    override fun updateContent(content: Content) {
        val entity = contentRepository.findContentEntityByContentId(contentId = content.contentId)
        // I'm going to use dirty checking. so use @Transactional
        // https://velog.io/@suk13574/JPA-%EC%98%81%EC%86%8D%EC%84%B1-%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%EC%9D%98-%EC%A0%84%EB%B0%98%EC%A0%81%EC%9D%B8-%EC%9D%B4%ED%95%B4%EA%B0%9C%EB%85%90-%EC%9E%A5%EC%A0%90-%EB%8F%99%EC%9E%91-%EB%B0%A9
        // https://beaniejoy.tistory.com/68

        // but Spring Data Jpa recommend to use it
        // https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference
        entity?.likedCount = content.likedCount
        contentRepository.save(entity)
    }
}