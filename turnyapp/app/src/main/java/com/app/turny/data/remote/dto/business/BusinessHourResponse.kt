package com.app.turny.data.remote.dto.business

data class BusinessHourResponse(

    val id: String,

    val diaSemana: Int,

    val diaNombre: String,

    val abierto: Boolean,

    val horaApertura: String?,

    val horaCierre: String?,

    val descansoInicio: String?,

    val descansoFin: String?
)