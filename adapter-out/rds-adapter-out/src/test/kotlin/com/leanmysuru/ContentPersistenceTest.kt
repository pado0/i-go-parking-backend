package com.leanmysuru

import com.leanmysuru.entity.ContentEntity
import com.leanmysuru.mapper.ContentMapper
import com.leanmysuru.repository.ContentRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import java.util.concurrent.ForkJoinPool

@SpringBootTest
@ContextConfiguration(classes = [SpringBootTestApplication::class])
class ContentPersistenceTest(
    private val contentRepository: ContentRepository,
) : StringSpec({
    "When content is disliked, the total count decreases by the input count - has concurrency issues" {
        contentRepository.deleteAll()
        val contentEntity = ContentEntity(1000)
        val saved = contentRepository.save(contentEntity)
        contentRepository.flush()

        suspend fun decreaseLikedCount(contentId: Long, count: Long) = coroutineScope {
            launch {
                val entity = contentRepository.findContentEntityByContentId(contentId)
                val content = ContentMapper.toDomain(entity)
                content?.decreaseLikedCount(count = count)
                entity?.likedCount = content?.likedCount ?: 0
                contentRepository.save(entity)
            }
        }

        val threadPool = ForkJoinPool(10)
        runBlocking(threadPool.asCoroutineDispatcher()) {
            repeat(100) {
                launch {
                    decreaseLikedCount(
                        contentId = saved.contentId,
                        count = 1,
                    )
                }
            }
        }

        threadPool.close()
        contentRepository.findContentEntityByContentId(saved.contentId)?.likedCount shouldBe 900L
    }
})
