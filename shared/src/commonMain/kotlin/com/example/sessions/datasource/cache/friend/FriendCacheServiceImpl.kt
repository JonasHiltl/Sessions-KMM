package com.example.sessions.datasource.cache.friend

import com.example.sessions.datasource.cache.FriendEntity
import com.example.sessions.datasource.cache.SessionDatabase
import com.example.sessions.model.Friend
import com.example.sessions.datasource.cache.FriendEntityQueries
import com.example.sessions.model.Profile
import com.example.sessions.model.toFriend
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow

class FriendCacheServiceImpl(
    private val sessionDatabase: SessionDatabase
) : FriendCacheService {
    private val queries: FriendEntityQueries = sessionDatabase.friendEntityQueries

    override fun add(friend: Friend) {
        queries.inserFriend(
            id = friend.profile.id,
            username = friend.profile.username,
            firstname = friend.profile.firstname,
            lastname = friend.profile.lastname,
            phone = friend.profile.phone,
            picture = friend.profile.picture,
            accepted = friend.accepted
        )
    }

    override fun add(friends: List<Friend>) {
        friends.map {
            queries.inserFriend(
                id = it.profile.id,
                username = it.profile.username,
                firstname = it.profile.firstname,
                lastname = it.profile.lastname,
                phone = it.profile.phone,
                picture = it.profile.picture,
                accepted = it.accepted
            )
        }
    }

    override fun get(id: Long): Flow<Query<Friend>>? {
        return try {
            return queries.getFriendById(
                id = id,
                mapper = { friendId, username, firstname, lastname, phone, picture, accepted ->
                    Friend(
                        Profile(friendId, username, firstname, lastname, phone, picture),
                        accepted
                    )
                }).asFlow()
        } catch (e: NullPointerException) {
            null
        }
    }

    override fun getAll(): Flow<List<Friend>> {
        TODO("Not yet implemented")
    }
}