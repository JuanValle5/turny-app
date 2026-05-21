package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface AppointmentApiService {

    @GET("api/appointments/mis-citas")
    suspend fun getMyAppointments(

        @Header("Authorization")
        token: String
    ): List<AppointmentResponse>
}