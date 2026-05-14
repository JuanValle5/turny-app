package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.login.LoginRequest
import com.app.turny.data.remote.dto.login.LoginResponse
import com.app.turny.data.remote.dto.register.RegisterRequest
import com.app.turny.data.remote.dto.register.RegisterResponse
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

    override suspend fun register(
        fullName: String,
        email: String,
        phone: String,
        password: String,
        role: Role
    ): RegisterResponse {

        val request = RegisterRequest(
            email = email,
            password = password,
            nombre = fullName, // 🔥 mapeo correcto
            telefono = phone,
            tipo = when(role) {
                Role.CLIENT -> "client"
                Role.BUSINESS -> "business"
            } // 🔥 CLAVE
        )

        return when(role) {

            Role.CLIENT -> {
                RetrofitInstance.api.registerClient(request)
            }

            Role.BUSINESS -> {
                RetrofitInstance.api.registerBusiness(request)
            }
        }
    }
}