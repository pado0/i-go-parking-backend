import com.boilerplate.domain.Content
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.launch

class CoroutineTest : StringSpec({
    /*
        coroutine
        - It may suspend its execution in one thread and resume in another one.
        - It can be thought of as light-weight thread (but different)
        - Differences that make their real-life usage different

     */
    "coroutine-basics docs practice" {
        val threadCount = 100
        val content = Content(
            contentId = 1,
            likedCount = 100,
        )

        runBlocking {
            // launch
            // - coroutine builder. it launches a new coroutine concurrently
            // - with the rest of the code which continues to work independently
            launch {
                for (i in 1..threadCount) {
//                    delay(1000)
                    println("world!1")
                }
            }

            launch {
                for (i in 1..threadCount) {
//                    delay(1000)
                    println("world!2")
                }
            }
            println("Hello")
        }

    }
})

