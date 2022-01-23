package com.example.sessions.datasource.network

import io.ktor.client.*

expect class KtorClientFactory {
    fun build(token: String): HttpClient
}