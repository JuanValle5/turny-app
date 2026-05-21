package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.business.BusinessCardResponse
import com.app.turny.domain.repository.BusinessRepository

class BusinessRepositoryImpl : BusinessRepository {

    override suspend fun getBusinesses():
            List<BusinessCardResponse> {

        return RetrofitInstance
            .businessApi
            .getBusinesses()
    }
}