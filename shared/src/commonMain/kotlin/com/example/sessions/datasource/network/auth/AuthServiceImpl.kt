package com.example.sessions.datasource.network.auth

import com.example.sessions.datasource.network.auth.model.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class AuthServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : AuthService {
    override suspend fun login(usernameOrEmail: String, password: String): LoginResDto {
        return httpClient.post {
            url("$baseUrl/user/auth/login")
            contentType(ContentType.Application.Json)
            body = LoginBody(usernameOrEmail, password)
        }
    }

    override suspend fun register(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): RegisterResDto {
        return httpClient.post {
            url("$baseUrl/user/auth/register")
            contentType(ContentType.Application.Json)
            body = RegisterBody(username, firstname, lastname, email, password)
        }
    }
}