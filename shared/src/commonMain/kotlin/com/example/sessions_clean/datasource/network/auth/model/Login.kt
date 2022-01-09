package com.example.sessions_clean.datasource.network.auth.model

import com.example.sessions_clean.domain.model.GenericNotification
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResDto(
    @SerialName("token")
    var token: String,

    @SerialName("message")
    var message: String
)

fun LoginResDto.toLoginRes(): LoginRes {
    return LoginRes(
        token = token
    )
}

data class LoginRes(
    var token: String,
)

@Serializable
data class LoginBody(
    val usernameOrEmail: String,
    val password: String,
)