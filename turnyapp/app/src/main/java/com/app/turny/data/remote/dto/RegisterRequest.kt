package com.app.turny.data.remote.dto

data class RegisterRequest(
    val email: String,
    val password: String,
    val nombre: String,
    val telefono: String,
    val tipo: String
)