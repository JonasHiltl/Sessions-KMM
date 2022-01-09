package com.example.sessions_clean.datasource.network.profile.model

import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.model.Profile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateResDto(
    @SerialName("profile")
    var profile: Profile,

    @SerialName("message")
    var message: String,
)

data class UpdateRes(
    var profile: Profile,

    var message: GenericNotification.Builder
)

@Serializable
data class UpdateBody(
    val username: String,
    val firstname: String,
    val lastname: String,
)
