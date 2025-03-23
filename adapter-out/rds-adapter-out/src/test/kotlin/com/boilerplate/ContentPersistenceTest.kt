package com.boilerplate

import com.boilerplate.adapter.out.rds.repository.ContentRepository
import io.kotest.core.spec.style.StringSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SpringBootTestApplication::class])
class ContentPersistenceTest(
    private val contentRepository: ContentRepository,
) : StringSpec({
})
