package com.example.sessions.datasource.network.friends

import com.example.sessions.model.Friend
import com.example.sessions.datasource.network.friends.model.FriendList
import com.example.sessions.model.MessageRes

interface FriendService {
    suspend fun get(id: Long): FriendList

    suspend fun search(id: Long, query: String, accepted: Boolean?): List<Friend>

    suspend fun follow(id: Long): MessageRes

    suspend fun accept(id: Long): MessageRes
}