package com.app.turny.data.remote.dto.register

data class RegisterRequest(
    val email: String,

    val password: String,

    val nombre: String,

    val telefono: String,

    val tipo: String,

    val nombreNegocio: String? = null,

    val categoria: String? = null,

    val direccion: String? = null
)