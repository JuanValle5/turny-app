package com.app.turny.data.remote.api

import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import com.app.turny.data.remote.dto.appointment.CambiarEstadoRequest
import com.app.turny.data.remote.dto.appointment.CreateAppointmentRequest
import com.app.turny.data.remote.dto.appointment.SlotResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AppointmentApiService {

    @GET("api/appointments/mis-citas")
    suspend fun getMyAppointments(

        @Header("Authorization")
        token: String
    ): List<AppointmentResponse>

    @GET("api/appointments/slots")
    suspend fun getSlots(

        @Query("negocioId")
        negocioId: String,

        @Query("servicioId")
        servicioId: String,

        @Query("fecha")
        fecha: String

    ): List<SlotResponse>

    @POST("api/appointments")
    suspend fun createAppointment(

        @Header("Authorization")
        token: String,

        @Body
        request: CreateAppointmentRequest

    ): AppointmentResponse

    @PATCH("api/appointments/{citaId}/estado")
    suspend fun changeStatus(

        @Header("Authorization")
        token: String,

        @Path("citaId")
        citaId: String,

        @Body
        request: CambiarEstadoRequest

    ): AppointmentResponse
}