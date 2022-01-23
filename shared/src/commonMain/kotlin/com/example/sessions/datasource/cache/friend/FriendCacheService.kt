package com.example.sessions.datasource.cache.friend

import com.example.sessions.model.Friend
import com.squareup.sqldelight.Query
import kotlinx.coroutines.flow.Flow

interface FriendCacheService {
    fun add(friend: Friend)

    fun add(friends: List<Friend>)

    fun get(id: Long): Flow<Query<Friend>>?

    fun getAll(): Flow<List<Friend>>
}