import com.boilerplate.domain.Content
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ContentTest :
    StringSpec({
        "When content is disliked, the total count decreases by the input count" {
            val content =
                Content(
                    contentId = 1,
                    likedCount = 100,
                )

            content.decreaseLikedCount()
            content.likedCount shouldBe 90
        }
    })
