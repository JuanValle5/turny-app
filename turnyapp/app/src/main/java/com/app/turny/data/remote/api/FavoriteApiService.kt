package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.favorite.FavoriteResponse
import com.app.turny.data.remote.dto.favorite.ToggleFavoriteResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoriteApiService {

    @GET("api/favorites")
    suspend fun getFavorites(

        @Header("Authorization")
        token: String

    ): List<FavoriteResponse>

    @POST("api/favorites/{negocioId}/toggle")
    suspend fun toggleFavorite(

        @Header("Authorization")
        token: String,

        @Path("negocioId")
        negocioId: String

    ): ToggleFavoriteResponse


    @GET("api/favorites/{negocioId}/check")
    suspend fun checkFavorite(

        @Header("Authorization")
        token: String,

        @Path("negocioId")
        negocioId: String

    ): ToggleFavoriteResponse
}