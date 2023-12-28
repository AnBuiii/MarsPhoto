package com.anbui.marsphoto

import SERVER_PORT
import com.anbui.marsphoto.model.MarsPhoto
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

const val MARS_PATH = "server/src/main/kotlin/com/anbui/marsphoto/model/mars_data.json"
    
fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0"){
        routing()
        configureSerialization()
    }
        .start(wait = true)

}

fun Application.routing() {
    routing {
        get("/") {
            call.respondText("Mars photos server")
        }
        get("/photos"){
            call.respond(getData())
        }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            },
        )
    }
}

fun getData(): List<MarsPhoto> {
    val jsonString = File(MARS_PATH).readText()
    return Json.decodeFromString<List<MarsPhoto>>(jsonString)
}
