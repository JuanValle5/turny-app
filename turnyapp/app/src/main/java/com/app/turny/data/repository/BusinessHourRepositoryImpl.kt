package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.business.BusinessHourRequest
import com.app.turny.data.remote.dto.business.BusinessHourResponse
import com.app.turny.domain.repository.BusinessHourRepository

class BusinessHourRepositoryImpl :
    BusinessHourRepository {

    override suspend fun getBusinessHours(
        negocioId: String
    ): List<BusinessHourResponse> {

        return RetrofitInstance
            .businessHourApi
            .getBusinessHours(
                negocioId
            )
    }

    override suspend fun saveBusinessHours(

        token: String,

        request: List<BusinessHourRequest>

    ): List<BusinessHourResponse> {

        return RetrofitInstance
            .businessHourApi
            .saveBusinessHours(

                token = "Bearer $token",

                request = request
            )
    }
}