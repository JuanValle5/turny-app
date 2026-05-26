package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.service.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApiService {

    @GET("api/services/{negocioId}")
    suspend fun getServices(

        @Path("negocioId")
        businessId: String

    ): List<ServiceResponse>
}