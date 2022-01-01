package com.example.sessions_clean.datasource.network

import io.ktor.client.*

expect class KtorClientFactory {
    fun build(): HttpClient
}