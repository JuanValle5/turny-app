package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.business.BusinessCardResponse
import com.app.turny.data.remote.dto.profile.NegocioProfileResponse

interface BusinessRepository {

    suspend fun getBusinesses():
            List<BusinessCardResponse>

    suspend fun getBusinessByCode(
        codigo: String
    ): BusinessCardResponse

    suspend fun getBusinessProfile(
        businessId: String
    ): NegocioProfileResponse
}