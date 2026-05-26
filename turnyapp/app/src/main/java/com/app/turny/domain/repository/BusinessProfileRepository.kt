package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.profile.NegocioProfileResponse

interface BusinessProfileRepository {

    suspend fun getProfile(
        token: String
    ): NegocioProfileResponse
}