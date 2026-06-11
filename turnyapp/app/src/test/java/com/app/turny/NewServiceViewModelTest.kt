package com.app.turny

import android.app.Application
import com.app.turny.ui.business.service.NewServiceViewModel
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NewServiceViewModelTest {

    //TEST 1 - llena correctamente todos los campos
    @Test
    fun serviceFields_areUpdatedCorrectly() {

        val application =
            mockk<Application>(relaxed = true)

        val viewModel =
            NewServiceViewModel(application)

        viewModel.onNameChange("Corte Premium")

        viewModel.onDescriptionChange(
            "Servicio completo"
        )

        viewModel.onDurationChange("60")

        viewModel.onPriceChange("35000")

        viewModel.onCategoryChange(
            "Barbería"
        )

        val state =
            viewModel.uiState.value

        assertEquals(
            "Corte Premium",
            state.name
        )

        assertEquals(
            "Servicio completo",
            state.description
        )

        assertEquals(
            "60",
            state.duration
        )

        assertEquals(
            "35000",
            state.price
        )

        assertEquals(
            "Barbería",
            state.category
        )
    }

    //TEST 2 - Verificar que un cambio no afecta los demás campos
    @Test
    fun changingPrice_doesNotModifyName() {

        val application =
            mockk<Application>(relaxed = true)

        val viewModel =
            NewServiceViewModel(application)

        viewModel.onNameChange(
            "Corte Ejecutivo"
        )

        viewModel.onPriceChange(
            "50000"
        )

        assertEquals(
            "Corte Ejecutivo",
            viewModel.uiState.value.name
        )
    }

    //TEST 3 - Verificar estado inicial de NewService
    @Test
    fun initialState_isEmpty() {

        val application =
            mockk<Application>(relaxed = true)

        val viewModel =
            NewServiceViewModel(application)

        val state =
            viewModel.uiState.value

        assertEquals("", state.name)
        assertEquals("", state.description)
        assertEquals("", state.duration)
        assertEquals("", state.price)
        assertEquals("", state.category)
    }
}