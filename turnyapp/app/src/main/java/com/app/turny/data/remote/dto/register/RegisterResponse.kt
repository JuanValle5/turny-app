package com.app.turny.data.remote.dto.register

data class RegisterResponse(

    val success: Boolean,

    val message: String? = null,

    val token: String? = null
)