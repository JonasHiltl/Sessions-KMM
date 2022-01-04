package com.example.sessions_clean.datasource.network.auth

import com.example.sessions_clean.datasource.network.auth.model.LoginBody
import com.example.sessions_clean.datasource.network.auth.model.LoginRes
import com.example.sessions_clean.datasource.network.auth.model.RegisterBody
import com.example.sessions_clean.datasource.network.auth.model.RegisterRes
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class AuthServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : AuthService {
    override suspend fun login(usernameOrEmail: String, password: String): LoginRes {
        return httpClient.post<LoginRes> {
            url("$baseUrl/auth/login")
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
    ): RegisterRes {
        return httpClient.post<RegisterRes> {
            url("$baseUrl/auth/register")
            contentType(ContentType.Application.Json)
            body = RegisterBody(username, firstname, lastname, email, password)
        }
    }
}