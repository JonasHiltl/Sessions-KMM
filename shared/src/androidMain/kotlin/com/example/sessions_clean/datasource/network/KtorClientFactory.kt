package com.example.sessions_clean.datasource.network

import com.example.sessions_clean.domain.util.Constants
import com.example.sessions_clean.domain.util.settings
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

actual class KtorClientFactory {
    actual fun build(token: String): HttpClient {
        val client = HttpClient(Android) {
            developmentMode = true
            install(Logging)
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        client.sendPipeline.intercept(HttpSendPipeline.State) {
            val accessToken =
                if (token.isBlank()) settings.getString(Constants.AUTH_TOKEN) else token
            context.headers.append("Authorization", "Bearer $accessToken")
        }

        return client
    }
}