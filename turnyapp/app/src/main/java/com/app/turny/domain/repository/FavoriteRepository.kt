package com.app.turny.domain.repository


import com.app.turny.data.remote.dto.favorite.FavoriteResponse
import com.app.turny.data.remote.dto.favorite.ToggleFavoriteResponse

interface FavoriteRepository {

    suspend fun getFavorites(
        token: String
    ): List<FavoriteResponse>

    suspend fun toggleFavorite(

        token: String,

        negocioId: String

    ): ToggleFavoriteResponse


    suspend fun checkFavorite(

        token: String,

        negocioId: String

    ): ToggleFavoriteResponse
}