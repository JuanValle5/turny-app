package com.app.turny.domain.repository


import com.app.turny.data.remote.dto.favorite.FavoriteResponse

interface FavoriteRepository {

    suspend fun getFavorites(
        token: String
    ): List<FavoriteResponse>
}