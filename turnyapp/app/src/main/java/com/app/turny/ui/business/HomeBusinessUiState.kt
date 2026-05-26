package com.app.turny.ui.business

data class HomeBusinessUiState(

    val userName: String = "",

    val totalAppointments: Int = 0,

    val confirmedAppointments: Int = 0,

    val pendingAppointments: Int = 0,

    val isLoading: Boolean = false,

    val error: String? = null
)