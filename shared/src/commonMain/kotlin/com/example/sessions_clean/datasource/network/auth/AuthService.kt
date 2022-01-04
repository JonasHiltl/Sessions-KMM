package com.example.sessions_clean.datasource.network.auth

import com.example.sessions_clean.datasource.network.auth.model.LoginRes
import com.example.sessions_clean.datasource.network.auth.model.RegisterRes

interface AuthService {
    suspend fun login(usernameOrEmail: String, password: String): LoginRes

    suspend fun register(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): RegisterRes
}