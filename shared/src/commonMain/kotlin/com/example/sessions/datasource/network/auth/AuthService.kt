package com.example.sessions.datasource.network.auth

import com.example.sessions.datasource.network.auth.model.LoginResDto
import com.example.sessions.datasource.network.auth.model.RegisterResDto

interface AuthService {
    suspend fun login(usernameOrEmail: String, password: String): LoginResDto

    suspend fun register(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): RegisterResDto
}