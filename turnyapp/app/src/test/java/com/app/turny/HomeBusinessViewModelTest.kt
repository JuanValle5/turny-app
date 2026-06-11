package com.app.turny

import android.app.Application
import com.app.turny.ui.business.home.HomeBusinessViewModel
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.time.LocalDate

class HomeBusinessViewModelTest {

    //TEST 1 - cambia fecha seleccionada
    @Test
    fun selectDate_updatesDate() {

        val application =
            mockk<Application>(relaxed = true)

        val viewModel =
            HomeBusinessViewModel(application)

        val date =
            LocalDate.of(2026, 12, 24)

        viewModel.selectDate(date)

        assertEquals(
            date,
            viewModel.uiState.value.selectedDate
        )
    }
}