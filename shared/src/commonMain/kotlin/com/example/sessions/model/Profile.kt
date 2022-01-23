package com.example.sessions.model

import com.example.sessions.datasource.cache.ProfileEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    @SerialName("id")
    var id: Long,

    @SerialName("username")
    var username: String,

    @SerialName("firstname")
    var firstname: String,

    @SerialName("lastname")
    var lastname: String?,

    @SerialName("phone")
    var phone: String? = null,

    @SerialName("picture")
    var picture: String? = null,
)

fun ProfileEntity.toProfile(): Profile {
    return Profile(
        id, username, firstname, lastname, phone, picture
    )
}