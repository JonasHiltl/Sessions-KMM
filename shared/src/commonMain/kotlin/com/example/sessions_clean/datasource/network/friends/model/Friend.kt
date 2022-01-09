package com.example.sessions_clean.datasource.network.friends.model

import com.example.sessions_clean.model.Profile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Friend(
    @SerialName("friend")
    var friend: Profile,

    @SerialName("accepted")
    var accepted: Boolean
)