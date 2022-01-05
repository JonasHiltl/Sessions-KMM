package com.example.sessions_clean.datasource.network.profile.model

import com.example.sessions_clean.model.Profile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateRes(
    @SerialName("profile")
    var profile: Profile,

    @SerialName("message")
    var message: String,
)

data class UpdateBody(
    val username: String,
    val firstname: String,
    val lastname: String,
)
