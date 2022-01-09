package com.example.sessions_clean.datasource.network.auth.model

import com.example.sessions_clean.domain.model.GenericNotification
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResDto(
    @SerialName("token")
    var token: String,

    @SerialName("message")
    var message: String
)

fun RegisterResDto.toRegisterRes(): RegisterRes {
    return RegisterRes(
        token = token
    )
}

data class RegisterRes(
    var token: String,
)

@Serializable
data class RegisterBody(
    val username: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
)
