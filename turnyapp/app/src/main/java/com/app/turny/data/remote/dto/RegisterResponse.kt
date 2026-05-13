package com.app.turny.data.remote.dto

data class RegisterResponse(

    val success: Boolean,

    val message: String? = null,

    val token: String? = null
)