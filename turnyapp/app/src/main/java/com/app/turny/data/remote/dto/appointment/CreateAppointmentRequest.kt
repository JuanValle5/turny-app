package com.app.turny.data.remote.dto.appointment

data class CreateAppointmentRequest(

    val negocioId: String,

    val servicioId: String,

    val fecha: String,

    val hora: String,

    val notasCliente: String?
)