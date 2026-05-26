package com.app.turny.data.remote.dto.service

data class ServiceResponse(

    val id: String,

    val nombre: String,

    val descripcion: String?,

    val duracion: Int,

    val duracionFormateada: String,

    val precio: Double,

    val precioDesde: Boolean?,

    val categoria: String?,

    val imagenUrl: String?,

    val orden: Int?,

    val activo: Boolean
)