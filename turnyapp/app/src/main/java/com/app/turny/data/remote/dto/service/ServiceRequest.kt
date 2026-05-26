package com.app.turny.data.remote.dto.service

data class ServiceRequest(

    val nombre: String,

    val descripcion: String?,

    val duracion: Int,

    val precio: Double,

    val precioDesde: Boolean?,

    val categoria: String?,

    val imagenUrl: String?,

    val orden: Int?
)