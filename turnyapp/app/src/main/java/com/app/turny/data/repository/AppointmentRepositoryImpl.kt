package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.appointment.AppointmentResponse
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
}