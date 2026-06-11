package com.app.turny

import android.app.Application
import com.app.turny.ui.client.reservation.ReservationViewModel
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.time.LocalDate

class ReservationViewModelTest {

    //TEST 1 - Cambia la fecha correctamente
    @Test
    fun selectDate_updatesSelectedDate() {

        val application =
            mockk<Application>(relaxed = true)

        val viewModel =
            ReservationViewModel(application)

        val date =
            LocalDate.of(2026, 6, 15)

        viewModel.selectDate(date)

        assertEquals(
            date,
            viewModel.uiState.value.selectedDate
        )
    }

    //TEST 2 - Cambia la hora correctamente
    @Test
    fun selectHour_updatesSelectedHour() {

        val application =
            mockk<Application>(relaxed = true)

        val viewModel =
            ReservationViewModel(application)

        viewModel.selectHour("10:30")

        assertEquals(
            "10:30",
            viewModel.uiState.value.selectedHour
        )
    }
}