package com.app.turny.data.remote.dto.profile

data class ClienteProfileResponse(

    val userId: String,

    val clienteId: String,

    val nombre: String,

    val email: String,

    val telefono: String?,

    val avatarUrl: String?,

    val fechaNacimiento: String?,

    val genero: String?,

    val direccion: String?,

    val notas: String?,

    val totalCitas: Int?,

    val totalGastado: Double?,

    val createdAt: String?
)