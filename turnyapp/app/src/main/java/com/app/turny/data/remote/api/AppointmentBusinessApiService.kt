package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AppointmentBusinessApiService {

    @GET("api/appointments/negocio")
    suspend fun getAppointmentsBusiness(

        @Header("Authorization")
        token: String,

        @Query("fecha")
        fecha: String

    ): List<AppointmentResponse>
}