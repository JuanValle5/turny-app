package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.service.ServiceRequest
import com.app.turny.data.remote.dto.service.ServiceResponse
import com.app.turny.domain.repository.ServiceRepository

class ServiceRepositoryImpl :
    ServiceRepository {

    override suspend fun getServices(
        businessId: String
    ): List<ServiceResponse> {

        return RetrofitInstance
            .serviceApi
            .getServices(businessId)
    }

    override suspend fun createService(

        token: String,

        request: ServiceRequest

    ): ServiceResponse {

        return RetrofitInstance
            .serviceApi
            .createService(

                token = "Bearer $token",

                request = request
            )
    }
}