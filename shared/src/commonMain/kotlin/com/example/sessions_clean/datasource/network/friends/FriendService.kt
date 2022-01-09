package com.example.sessions_clean.datasource.network.friends

import com.example.sessions_clean.datasource.network.friends.model.Friend
import com.example.sessions_clean.datasource.network.friends.model.FriendList
import com.example.sessions_clean.model.MessageRes

interface FriendService {
    suspend fun get(id: String): FriendList

    suspend fun search(id: String, query: String, accepted: Boolean?): List<Friend>

    suspend fun follow(id: String): MessageRes

    suspend fun accept(id: String): MessageRes
}