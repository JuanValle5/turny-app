package com.app.turny.ui.client

import com.app.turny.data.remote.dto.appointment.AppointmentResponse

data class AppointmentsUiState(

    val isLoading: Boolean = false,

    val appointments:
    List<AppointmentResponse> = emptyList(),

    val userName: String = "",

    val selectedTab:
    AppointmentsTab =
        AppointmentsTab.UPCOMING,

    val error: String? = null
)