package com.igoparking

import com.igoparking.adapter.out.rds.repository.ContentRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SpringBootTestApplication::class])
class ContentPersistenceTest(
    private val contentRepository: ContentRepository,
)
