package com.app.turny.data.remote.dto.business

data class BusinessHourRequest(

    val diaSemana: Int,

    val abierto: Boolean,

    val horaApertura: String?,

    val horaCierre: String?,

    val descansoInicio: String?,

    val descansoFin: String?
)
