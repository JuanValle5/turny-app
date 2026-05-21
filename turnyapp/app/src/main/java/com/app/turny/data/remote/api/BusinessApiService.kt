package com.app.turny.data.remote.api


import com.app.turny.data.remote.dto.business.BusinessCardResponse
import retrofit2.http.GET

interface BusinessApiService {

    @GET("api/businesses")
    suspend fun getBusinesses():
            List<BusinessCardResponse>
}