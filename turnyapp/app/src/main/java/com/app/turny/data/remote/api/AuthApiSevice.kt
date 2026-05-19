package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.login.LoginRequest
import com.app.turny.data.remote.dto.login.LoginResponse
import com.app.turny.data.remote.dto.register.RegisterRequest
import com.app.turny.data.remote.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse


}