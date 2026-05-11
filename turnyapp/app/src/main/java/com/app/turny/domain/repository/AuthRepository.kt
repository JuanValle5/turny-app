package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.LoginResponse
import com.app.turny.domain.model.Role

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String,
        role: Role
    ): LoginResponse
}