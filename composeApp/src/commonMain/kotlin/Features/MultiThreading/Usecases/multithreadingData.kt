package Features.MultiThreading.Usecases
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

data class Post (val userId: Int, var id: Int, val title : String, val body: String )
class multithreadingData {
    fun getPostData(): Post {
        return Post(1, 1, "The Hobbit", "The Hobbit, or There and Back Again is a children's fantasy novel by the English author J. R. R. Tolkien.")
    }

    fun getRandomPostData() : Post {
        runBlocking {
            val client = HttpClient(CIO)
            val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
            println(response.status)
            println(response)
        }
        return Post(1, 1, "The Hobbit", "The Hobbit, or There and Back Again is a children's fantasy novel by the English author J. R. R. Tolkien.")
    }
}