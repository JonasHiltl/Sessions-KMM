package com.example.sessions_clean.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Friend(
    @SerialName("friend")
    var friend: Profile,

    @SerialName("accepted")
    var accepted: Boolean
)