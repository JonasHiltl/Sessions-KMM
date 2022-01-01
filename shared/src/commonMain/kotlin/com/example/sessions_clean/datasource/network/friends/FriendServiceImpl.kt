package com.example.sessions_clean.datasource.network.friends

import com.example.sessions_clean.model.Friend
import com.example.sessions_clean.model.FriendList
import com.example.sessions_clean.model.Profile
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.collections.get

class FriendServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : FriendService {
    override suspend fun get(id: String): FriendList {
        return httpClient.get<FriendList> {
            url("$baseUrl/profile/friends/$id")
        }
    }

    override suspend fun search(id: String, query: String, accepted: Boolean?): List<Friend> {
        return httpClient.get<List<Friend>> {
            url("$baseUrl/profile/friends/$id/$query")
        }
    }
}