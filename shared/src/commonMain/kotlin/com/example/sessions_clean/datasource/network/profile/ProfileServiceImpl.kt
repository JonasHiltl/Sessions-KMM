package com.example.sessions_clean.datasource.network.profile

import com.example.sessions_clean.datasource.network.profile.model.ProfileBody
import com.example.sessions_clean.datasource.network.profile.model.UpdateRes
import com.example.sessions_clean.model.Profile
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class ProfileServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : ProfileService {
    override suspend fun get(id: String): Profile {
        return httpClient.get<Profile> {
            url("$baseUrl/profile/$id")
        }
    }

    override suspend fun create(username: String, firstname: String, lastname: String): Profile {
        return httpClient.post<Profile> {
            url("$baseUrl/profile/")
            contentType(ContentType.Application.Json)
            body = ProfileBody(username, firstname, lastname)
        }
    }

    override suspend fun update(username: String, firstname: String, lastname: String): UpdateRes {
        return httpClient.patch<UpdateRes> {
            url("$baseUrl/profile/")
            contentType(ContentType.Application.Json)
            body = ProfileBody(username, firstname, lastname)
        }
    }

    override suspend fun me(): Profile {
        return httpClient.get<Profile> {
            url("$baseUrl/profile/me")
        }
    }

    override suspend fun checkProfileName(username: String): Boolean {
        return httpClient.get<Boolean> {
            url("$baseUrl/profile/checkUsername/$username")
        }
    }
}