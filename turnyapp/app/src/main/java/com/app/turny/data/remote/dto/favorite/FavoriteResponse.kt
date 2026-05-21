package com.app.turny.data.remote.dto.favorite

data class FavoriteResponse(

    val favoriteId: String,

    val negocioId: String,

    val negocioNombre: String,

    val negocioCategoria: String,

    val negocioDireccion: String,

    val negocioImagen: String?,

    val negocioLogo: String?,

    val rating: Double,

    val totalResenas: Int,

    val guardadoEn: String
)