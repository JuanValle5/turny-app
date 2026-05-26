package com.app.turny.ui.business

import com.app.turny.data.remote.dto.appointment.AppointmentResponse
import java.time.LocalDate

data class HomeBusinessUiState(

    val userName: String = "",

    val selectedDate: LocalDate =
        LocalDate.now(),

    val appointments:
    List<AppointmentResponse> = emptyList(),

    val totalAppointments: Int = 0,

    val confirmedAppointments: Int = 0,

    val pendingAppointments: Int = 0,

    val isLoading: Boolean = false,

    val error: String? = null
)