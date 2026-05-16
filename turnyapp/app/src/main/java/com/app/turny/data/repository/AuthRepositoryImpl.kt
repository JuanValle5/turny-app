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
                RetrofitInstance.api.loginClient(
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
        role: Role,
        businessType: String?,
        businessName: String?,
        businessAddress: String?
    ): RegisterResponse {

        val request = RegisterRequest(

            email = email,

            password = password,

            nombre = fullName,

            telefono = phone,

            tipo = when(role){

                Role.CLIENT -> "client"

                Role.BUSINESS -> "business"
            },

            categoria = businessType,

            nombreNegocio = businessName,

            direccion = businessAddress
        )

        return when(role) {

            Role.CLIENT -> {
                RetrofitInstance.api.registerClient(request)
            }

            Role.BUSINESS -> {
                RetrofitInstance.api.registerClient(request)
            }
        }
    }
}