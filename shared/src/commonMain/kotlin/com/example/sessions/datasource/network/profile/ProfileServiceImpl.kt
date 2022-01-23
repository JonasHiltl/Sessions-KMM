package com.example.sessions.datasource.network.profile

import com.example.sessions.datasource.network.profile.model.ProfileBody
import com.example.sessions.datasource.network.profile.model.UpdateResDto
import com.example.sessions.model.Profile
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class ProfileServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : ProfileService {
    override suspend fun get(id: Long): Profile {
        return httpClient.get<Profile> {
            url("$baseUrl/user/$id")
        }
    }

    override suspend fun create(username: String, firstname: String, lastname: String): Profile {
        return httpClient.post<Profile> {
            url("$baseUrl/user/")
            contentType(ContentType.Application.Json)
            body = ProfileBody(username, firstname, lastname)
        }
    }

    override suspend fun update(
        username: String,
        firstname: String,
        lastname: String
    ): UpdateResDto {
        return httpClient.patch<UpdateResDto> {
            url("$baseUrl/user/")
            contentType(ContentType.Application.Json)
            body = ProfileBody(username, firstname, lastname)
        }
    }

    override suspend fun me(): Profile {
        return httpClient.get<Profile> {
            url("$baseUrl/user/me")
        }
    }

    override suspend fun checkProfileName(username: String): Boolean {
        return httpClient.get<Boolean> {
            url("$baseUrl/user/checkUsername/$username")
        }
    }
}