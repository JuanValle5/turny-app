package com.app.turny.data.remote.dto.appointment

data class AppointmentResponse(

    val id: String,

    val negocioId: String,

    val negocioNombre: String,

    val negocioImagen: String?,

    val servicioId: String,

    val servicioNombre: String,

    val duracion: Int,

    val duracionFormateada: String,

    val fecha: String,

    val hora: String,

    val horaFin: String,

    val precio: Double,

    val estado: String,

    val notasCliente: String?,

    val notasNegocio: String?
)