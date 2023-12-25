import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName("img_src") val imgSrc: String
)

class Greeting {
    private val client = HttpClient(CIO){
        install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
        }
    }
    private val platform = getPlatform()

    suspend fun greeting(): List<MarsPhoto>{
        val response = client.get("http://$SERVER_URL:$SERVER_PORT/$MARS_ENDPOINT").body<List<MarsPhoto>>()
        return response
    }

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}