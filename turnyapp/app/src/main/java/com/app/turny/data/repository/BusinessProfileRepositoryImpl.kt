package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.profile.NegocioProfileResponse
import com.app.turny.domain.repository.BusinessProfileRepository

class BusinessProfileRepositoryImpl :
    BusinessProfileRepository {

    override suspend fun getProfile(
        token: String
    ): NegocioProfileResponse {

        return RetrofitInstance
            .profileBusinessApi
            .getBusinessProfile(

                token = "Bearer $token"
            )
    }
}