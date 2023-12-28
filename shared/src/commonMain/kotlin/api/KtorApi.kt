package api

import io.ktor.client.*
import io.ktor.client.request.*
import model.MarsPhoto

interface KtorApi {
   val client: HttpClient
   suspend fun getMars(): List<MarsPhoto>
}
    