package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
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
}