package com.example.sessions.model

import com.example.sessions.datasource.cache.FriendEntity
import com.example.sessions.model.Profile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Friend(
    @SerialName("friend")
    var profile: Profile,

    @SerialName("accepted")
    var accepted: Boolean
)


fun FriendEntity.toFriend(): Friend {
    return Friend(
        profile = Profile(
            id, username, firstname, lastname, phone, picture
        ),
        accepted
    )
}