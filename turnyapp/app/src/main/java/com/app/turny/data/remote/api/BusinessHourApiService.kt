package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.business.BusinessHourRequest
import com.app.turny.data.remote.dto.business.BusinessHourResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Path

interface BusinessHourApiService {

    @GET("api/business-hours/{negocioId}")
    suspend fun getBusinessHours(

        @Path("negocioId")
        negocioId: String

    ): List<BusinessHourResponse>

    @PUT("api/business-hours")
    suspend fun saveBusinessHours(

        @Header("Authorization")
        token: String,

        @Body
        request: List<BusinessHourRequest>

    ): List<BusinessHourResponse>
}