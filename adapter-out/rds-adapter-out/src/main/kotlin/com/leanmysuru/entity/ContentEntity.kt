package com.leanmysuru.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 *  Entity shouldn't be data class in kotlin
 *  JPA should use proxy for lazy loading, but it cannot apply to final class
 *  Every Kotlin class is final, but we set it allopen in gradle.
 *  Although, data class is not converted to open class.
 *  And Data class implement equals and hashcode automatically.
 *  But, it is only applied to inner property in contructor.
 *
 *  cc. https://velog.io/@heyday_7/JPA-Entity-%EC%8B%AC%EC%B8%B5%ED%83%90%EA%B5%AC-1-Entity%EC%97%90-Kotlin-Data-class%EB%A5%BC-%EC%8D%A8%EB%8F%84-%EB%90%A0%EA%B9%8C
 */


@Entity
@Table(name = "content")
class ContentEntity(
    var likedCount: Long,
) {
    // I decided define @Id id at the body of class
    // if Entity isn't persisted, it doesn't have id
    // cc. https://multifrontgarden.tistory.com/304

    // I decided to use IDENTITY strategy
    // IDENTITY
    // Delegate PK creation to DB. So, it can create ID after insert to DB
    // But, JPA must have to manage data in persistent context.
    // So when you use this strategy, insert query is called when you call a save() method - it flushes query at save(). (not after commit for flush)
    // cc. https://newwisdom.tistory.com/90

    // SEQUENCE for bulk insert
    // cc. https://velog.io/@rainmaker007/spring-batch-jpa-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C-ID-%EC%83%9D%EC%84%B1%EC%A0%84%EB%9E%B5%EC%97%90-%EB%94%B0%EB%A5%B8-bulk-insert-%ED%95%98%EB%8A%94%EB%B2%95
    // cc. https://fourjae.tistory.com/entry/Spring-boot-JPA-%EA%B8%B0%EB%B3%B8-%ED%82%A4-%EC%83%9D%EC%84%B1-%EC%A0%84%EB%9E%B5AUTO-IDENTITY-SEQUENCE-TABLE-UUID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val contentId: Long = 0L
}