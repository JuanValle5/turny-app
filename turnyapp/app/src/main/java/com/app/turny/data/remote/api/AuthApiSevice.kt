package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.LoginRequest
import com.app.turny.data.remote.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("login")
    suspend fun loginClient(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("login/1")
    suspend fun loginBusiness(
        @Body request: LoginRequest
    ): LoginResponse
}