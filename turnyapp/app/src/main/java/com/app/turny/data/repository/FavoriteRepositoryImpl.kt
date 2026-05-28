package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.favorite.FavoriteResponse
import com.app.turny.data.remote.dto.favorite.ToggleFavoriteResponse
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

    override suspend fun toggleFavorite(

        token: String,

        negocioId: String

    ): ToggleFavoriteResponse {

        return RetrofitInstance
            .favoriteApi
            .toggleFavorite(

                token = "Bearer $token",

                negocioId = negocioId
            )
    }

    override suspend fun checkFavorite(

        token: String,

        negocioId: String

    ): ToggleFavoriteResponse {

        return RetrofitInstance
            .favoriteApi
            .checkFavorite(

                token = "Bearer $token",

                negocioId = negocioId
            )
    }
}