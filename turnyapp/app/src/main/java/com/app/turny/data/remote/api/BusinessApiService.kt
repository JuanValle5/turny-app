package com.app.turny.data.remote.api


import com.app.turny.data.remote.dto.business.BusinessCardResponse
import com.app.turny.data.remote.dto.profile.NegocioProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BusinessApiService {

    @GET("api/businesses")
    suspend fun getBusinesses():
            List<BusinessCardResponse>

    @GET("api/businesses/{negocioId}")
    suspend fun getBusinessProfile(

        @Path("negocioId")
        negocioId: String

    ): NegocioProfileResponse
}