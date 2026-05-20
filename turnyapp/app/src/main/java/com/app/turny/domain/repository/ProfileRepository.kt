package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.profile.ClienteProfileResponse

interface ProfileRepository {

    suspend fun getClienteProfile(
        token: String
    ): ClienteProfileResponse
}