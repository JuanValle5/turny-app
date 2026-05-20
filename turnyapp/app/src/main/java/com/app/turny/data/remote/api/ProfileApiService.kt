package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.profile.ClienteProfileResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApiService {

    @GET("api/profile/cliente")
    suspend fun getClienteProfile(

        @Header("Authorization")
        token: String
    ): ClienteProfileResponse
}