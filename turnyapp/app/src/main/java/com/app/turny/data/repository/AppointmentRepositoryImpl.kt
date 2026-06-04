package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import com.app.turny.data.remote.dto.appointment.CambiarEstadoRequest
import com.app.turny.data.remote.dto.appointment.CreateAppointmentRequest
import com.app.turny.data.remote.dto.appointment.SlotResponse
import com.app.turny.domain.repository.AppointmentRepository

class AppointmentRepositoryImpl :
    AppointmentRepository {

    override suspend fun getMyAppointments(
        token: String
    ): List<AppointmentResponse> {

        return RetrofitInstance
            .appointmentApi
            .getMyAppointments(

                token = "Bearer $token"
            )
    }

    override suspend fun getSlots(

        negocioId: String,

        servicioId: String,

        fecha: String

    ): List<SlotResponse> {

        return RetrofitInstance
            .appointmentApi
            .getSlots(

                negocioId = negocioId,

                servicioId = servicioId,

                fecha = fecha
            )
    }

    override suspend fun createAppointment(

        token: String,

        request: CreateAppointmentRequest

    ): AppointmentResponse {

        return RetrofitInstance
            .appointmentApi
            .createAppointment(

                token = "Bearer $token",

                request = request
            )
    }

    override suspend fun changeStatus(

        token: String,

        citaId: String,

        request: CambiarEstadoRequest

    ): AppointmentResponse {

        return RetrofitInstance
            .appointmentApi
            .changeStatus(

                token = "Bearer $token",

                citaId = citaId,

                request = request
            )
    }
}