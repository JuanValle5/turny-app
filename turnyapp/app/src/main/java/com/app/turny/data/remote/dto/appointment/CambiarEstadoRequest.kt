package com.app.turny.data.remote.dto.appointment

data class CambiarEstadoRequest(

    val estado: String,

    val motivo: String?
)