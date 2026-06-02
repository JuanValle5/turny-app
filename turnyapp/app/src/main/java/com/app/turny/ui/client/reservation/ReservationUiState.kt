package com.app.turny.ui.client.reservation

import com.app.turny.data.remote.dto.appointment.SlotResponse
import java.time.LocalDate

data class ReservationUiState(

    val selectedDate:
    LocalDate = LocalDate.now(),

    val selectedHour: String = "",

    val notes: String = "",

    val slots:
    List<SlotResponse> = emptyList(),

    val isLoading: Boolean = false,

    val success: Boolean = false,

    val error: String? = null
)