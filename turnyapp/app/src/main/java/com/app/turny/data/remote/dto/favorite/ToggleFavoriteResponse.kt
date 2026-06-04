package com.app.turny.data.remote.dto.favorite

data class ToggleFavoriteResponse(

    val negocioId: String,

    val esFavorito: Boolean,

    val mensaje: String
)