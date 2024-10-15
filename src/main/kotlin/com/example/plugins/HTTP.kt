package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*

fun Application.configureHTTP() {
    install(CORS) {
        anyHost() // Allow requests from any origin. For production, specify the allowed origins.
        allowMethod(HttpMethod.Options) // Allow OPTIONS method
        allowMethod(HttpMethod.Get) // Allow GET method
        allowMethod(HttpMethod.Post) // Allow POST method
        allowMethod(HttpMethod.Put) // Allow PUT method
        allowMethod(HttpMethod.Delete)
        allowHeader(HttpHeaders.ContentType) // Allow Content-Type header
        allowHeader(HttpHeaders.Accept)
        allowHost("localhost:3000") // Replace with your production frontend URL

        allowHeader(HttpHeaders.Authorization) // Allow Authorization header
    }
}
