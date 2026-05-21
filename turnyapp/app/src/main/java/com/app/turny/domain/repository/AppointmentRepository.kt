package com.app.turny.domain.repository

import com.app.turny.data.remote.dto.appointment.AppointmentResponse

interface AppointmentRepository {

    suspend fun getMyAppointments(
        token: String
    ): List<AppointmentResponse>
}