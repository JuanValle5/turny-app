package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.profile.ClienteProfileResponse
import com.app.turny.domain.repository.ProfileRepository

class ProfileRepositoryImpl : ProfileRepository {

    override suspend fun getClienteProfile(
        token: String
    ): ClienteProfileResponse {

        return RetrofitInstance.profileApi.getClienteProfile(

            token = "Bearer $token"
        )
    }
}