package com.example.sessions_clean.datasource.network.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRes(
    @SerialName("username")
    var username: String,

    @SerialName("firstname")
    var firstname: String,

    @SerialName("lastname")
    var lastname: String,

    @SerialName("email")
    var email: String,

    @SerialName("password")
    var password: String,
)

data class RegisterBody(
    val username: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
)
