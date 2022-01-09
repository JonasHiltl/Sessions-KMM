package com.example.sessions_clean.datasource.network.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRes(
    @SerialName("token")
    var token: String,

    @SerialName("message")
    var message: String
)

@Serializable
data class LoginBody(
    val usernameOrEmail: String,
    val password: String,
)