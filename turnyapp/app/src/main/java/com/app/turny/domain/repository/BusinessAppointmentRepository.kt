package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.appointment.AppointmentResponse

interface BusinessAppointmentRepository {

    suspend fun getAppointments(

        token: String,

        fecha: String

    ): List<AppointmentResponse>
}