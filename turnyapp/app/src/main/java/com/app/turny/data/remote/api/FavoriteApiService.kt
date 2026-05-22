package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.favorite.FavoriteResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface FavoriteApiService {

    @GET("api/favorites")
    suspend fun getFavorites(

        @Header("Authorization")
        token: String

    ): List<FavoriteResponse>
}