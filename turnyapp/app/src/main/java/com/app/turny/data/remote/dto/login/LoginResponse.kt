package com.app.turny.data.remote.dto.login

data class LoginResponse(
    val token: String,

    val userId: String,

    val tipo: String,

    val nombre: String,

    val email: String
)