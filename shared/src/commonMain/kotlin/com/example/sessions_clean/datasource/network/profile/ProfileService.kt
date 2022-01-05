package com.example.sessions_clean.datasource.network.profile

import com.example.sessions_clean.datasource.network.profile.model.UpdateRes
import com.example.sessions_clean.model.Profile

interface ProfileService {
    suspend fun get(id: String): Profile

    suspend fun create(username: String, firstname: String, lastname: String): Profile

    suspend fun update(username: String, firstname: String, lastname: String): UpdateRes

    suspend fun me(): Profile

    suspend fun checkProfileName(username: String): Boolean
}