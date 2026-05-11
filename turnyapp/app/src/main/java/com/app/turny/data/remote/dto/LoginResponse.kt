package com.app.turny.data.remote.dto

data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val message: String?
)