package com.app.turny.data.remote.dto.profile

data class NegocioProfileResponse(

    val userId: String,

    val negocioId: String,

    val nombre: String,

    val email: String,

    val telefono: String,

    val avatarUrl: String?,

    val nombreNegocio: String,

    val categoria: String,

    val descripcion: String?,

    val direccion: String,

    val ciudad: String?,

    val codigoPostal: String?,

    val latitud: Double?,

    val longitud: Double?,

    val whatsapp: String?,

    val emailNegocio: String?,

    val website: String?,

    val imagenUrl: String?,

    val logoUrl: String?,

    val codigo: String,

    val rating: Double?,

    val totalResenas: Int?,

    val verificado: Boolean?,

    val createdAt: String
)