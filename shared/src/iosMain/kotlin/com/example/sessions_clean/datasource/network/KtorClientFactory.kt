package com.example.sessions_clean.datasource.network

import com.example.sessions_clean.domain.util.Constants
import com.example.sessions_clean.domain.util.settings
import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json

actual class KtorClientFactory {
    actual fun build(): HttpClient {
        return HttpClient(Ios) {
            install(Logging)
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            accessToken = settings.getString(Constants.AUTH_TOKEN),
                            refreshToken = ""
                        )
                    }
                }
            }
        }
    }
}