package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.profile.NegocioProfileResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileBusinessApiService {

    @GET("api/profile/negocio")
    suspend fun getBusinessProfile(

        @Header("Authorization")
        token: String

    ): NegocioProfileResponse
}