package api

import MARS_ENDPOINT
import SERVER_PORT
import SERVER_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import model.MarsPhoto

class KtorApiImpl() : KtorApi {

    override val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getMars(): List<MarsPhoto> {
        return try {
            return client.get("http://$SERVER_URL:$SERVER_PORT/$MARS_ENDPOINT")
                .body<List<MarsPhoto>>()
        } catch (e: Exception) {
            emptyList()
        }
    }
}

