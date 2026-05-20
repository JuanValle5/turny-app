package com.app.turny.data.remote.dto.business


data class BusinessCardResponse(

    val negocioId: String,

    val nombre: String,

    val categoria: String,

    val direccion: String,

    val logoUrl: String?,

    val rating: Double,

    val totalResenas: Int,

    val horarioHoy: String
)
