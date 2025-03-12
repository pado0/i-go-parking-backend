import com.leanmysuru.domain.Content
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContentTest : StringSpec({
    "When content is disliked, the total count decreases by the input count" {
        val content = Content(
            contentId = 1,
            likedCount = 100,
        )

        content.decreaseLikedCount(10)
        content.likedCount shouldBe 90
    }
})

