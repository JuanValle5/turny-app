package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.service.ServiceResponse

interface ServiceRepository {

    suspend fun getServices(
        businessId: String
    ): List<ServiceResponse>
}