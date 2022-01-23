package com.example.sessions.datasource.network.friends.model

import com.example.sessions.model.Profile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendList(
    @SerialName("count")
    var count: Int,

    @SerialName("friends")
    var friends: List<Profile>?,
)
