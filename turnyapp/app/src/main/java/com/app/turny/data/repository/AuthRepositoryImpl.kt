package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.LoginRequest
import com.app.turny.data.remote.dto.LoginResponse
import com.app.turny.domain.model.Role
import com.app.turny.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override suspend fun login(
        email: String,
        password: String,
        role: Role
    ): LoginResponse {

        return when(role) {

            Role.CLIENT -> {
                RetrofitInstance.api.loginClient(
                    LoginRequest(email, password)
                )
            }

            Role.BUSINESS -> {
                RetrofitInstance.api.loginBusiness(
                    LoginRequest(email, password)
                )
            }
        }
    }
}