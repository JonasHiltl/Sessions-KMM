package com.example.sessions_clean.datasource.network.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRes(
    @SerialName("token")
    var token: String,

    @SerialName("message")
    var message: String
)

data class RegisterBody(
    val username: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
)
