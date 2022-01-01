package com.example.sessions_clean.datasource.network.friends

import com.example.sessions_clean.model.Friend
import com.example.sessions_clean.model.FriendList

interface FriendService {
    suspend fun get(id: String): FriendList

    suspend fun search(id: String, query: String, accepted: Boolean?): List<Friend>
}