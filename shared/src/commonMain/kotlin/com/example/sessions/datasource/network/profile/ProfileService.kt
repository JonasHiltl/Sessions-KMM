package com.example.sessions.datasource.network.profile

import com.example.sessions.datasource.network.profile.model.UpdateResDto
import com.example.sessions.model.Profile

interface ProfileService {
    suspend fun get(id: Long): Profile

    suspend fun create(username: String, firstname: String, lastname: String): Profile

    suspend fun update(username: String, firstname: String, lastname: String): UpdateResDto

    suspend fun me(): Profile

    suspend fun checkProfileName(username: String): Boolean
}