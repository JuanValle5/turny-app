package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.favorite.FavoriteResponse
import com.app.turny.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl :
    FavoriteRepository {

    override suspend fun getFavorites(
        token: String
    ): List<FavoriteResponse> {

        return RetrofitInstance
            .favoriteApi
            .getFavorites(

                token = "Bearer $token"
            )
    }
}