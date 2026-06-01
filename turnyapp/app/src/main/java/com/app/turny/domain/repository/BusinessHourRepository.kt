package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.business.BusinessHourRequest
import com.app.turny.data.remote.dto.business.BusinessHourResponse

interface BusinessHourRepository {

    suspend fun getBusinessHours(
        negocioId: String
    ): List<BusinessHourResponse>

    suspend fun saveBusinessHours(

        token: String,

        request: List<BusinessHourRequest>

    ): List<BusinessHourResponse>
}