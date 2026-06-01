package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import com.app.turny.data.remote.dto.appointment.CambiarEstadoRequest
import com.app.turny.data.remote.dto.appointment.CreateAppointmentRequest
import com.app.turny.data.remote.dto.appointment.SlotResponse

interface AppointmentRepository {

    suspend fun getMyAppointments(
        token: String
    ): List<AppointmentResponse>

    suspend fun getSlots(

        negocioId: String,

        servicioId: String,

        fecha: String

    ): List<SlotResponse>

    suspend fun createAppointment(

        token: String,

        request: CreateAppointmentRequest

    ): AppointmentResponse

    suspend fun changeStatus(

        token: String,

        citaId: String,

        request: CambiarEstadoRequest

    ): AppointmentResponse
}