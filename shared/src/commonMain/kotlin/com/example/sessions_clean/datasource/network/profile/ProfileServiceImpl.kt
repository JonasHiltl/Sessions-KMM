package com.example.sessions_clean.datasource.network.profile

import com.example.sessions_clean.model.Profile
import io.ktor.client.*
import io.ktor.client.request.*

class ProfileServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
): ProfileService {
    override suspend fun get(id: String): Profile {
        return httpClient.get<Profile> {
            url("$baseUrl/profile/$id")
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