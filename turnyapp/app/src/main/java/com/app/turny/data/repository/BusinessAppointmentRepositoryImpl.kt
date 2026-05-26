package com.app.turny.data.repository

import com.app.turny.data.remote.RetrofitInstance
import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import com.app.turny.domain.repository.BusinessAppointmentRepository

class BusinessAppointmentRepositoryImpl :
    BusinessAppointmentRepository {

    override suspend fun getAppointments(

        token: String,

        fecha: String

    ): List<AppointmentResponse> {

        return RetrofitInstance
            .appointmentBusinessApi
            .getAppointmentsBusiness(

                token = "Bearer $token",

                fecha = fecha
            )
    }
}