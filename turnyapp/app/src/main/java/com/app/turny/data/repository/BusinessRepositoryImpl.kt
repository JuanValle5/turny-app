package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.business.BusinessCardResponse
import com.app.turny.data.remote.dto.profile.NegocioProfileResponse
import com.app.turny.domain.repository.BusinessRepository

class BusinessRepositoryImpl : BusinessRepository {

    override suspend fun getBusinesses():
            List<BusinessCardResponse> {

        return RetrofitInstance
            .businessApi
            .getBusinesses()
    }

    override suspend fun getBusinessProfile(
        businessId: String
    ): NegocioProfileResponse {

        return RetrofitInstance
            .businessApi
            .getBusinessProfile(
                businessId
            )
    }
}