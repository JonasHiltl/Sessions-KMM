package com.example.sessions.datasource.network.friends

import com.example.sessions.model.Friend
import com.example.sessions.datasource.network.friends.model.FriendList
import com.example.sessions.model.MessageRes
import io.ktor.client.*
import io.ktor.client.request.*

class FriendServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : FriendService {
    override suspend fun get(id: Long): FriendList {
        return httpClient.get<FriendList> {
            url("$baseUrl/profile/friends/$id")
        }
    }

    override suspend fun search(id: Long, query: String, accepted: Boolean?): List<Friend> {
        return httpClient.get<List<Friend>> {
            url("$baseUrl/profile/friends/$id/$query")
            parameter("accepted", accepted)
        }
    }

    override suspend fun follow(id: Long): MessageRes {
        return httpClient.put<MessageRes> {
            url("$baseUrl/profile/friends/follow/$id")
        }
    }

    override suspend fun accept(id: Long): MessageRes {
        return httpClient.put<MessageRes> {
            url("$baseUrl/profile/friends/accept/$id")
        }
    }
}