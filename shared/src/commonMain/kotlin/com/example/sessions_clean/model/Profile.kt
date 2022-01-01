package com.example.sessions_clean.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    @SerialName("id")
    var id: Int,

    @SerialName("username")
    var username: String,

    @SerialName("firstname")
    var firstname: String,

    @SerialName("lastname")
    var lastname: String?,

    @SerialName("phone")
    var phone: String?,

    @SerialName("picture")
    var picture: String?,
)
