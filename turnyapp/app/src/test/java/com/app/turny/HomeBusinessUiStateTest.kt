package com.app.turny

import com.app.turny.ui.business.home.HomeBusinessUiState
import junit.framework.TestCase.assertTrue
import org.junit.Test

class HomeBusinessUiStateTest {

    //Verifica que el estado de carga de la pantalla principal del negocio funcione correctamente.
    @Test
    fun homeBusinessStateStoresDataCorrectly() {

        val state = HomeBusinessUiState(
            isLoading = true
        )

        assertTrue(state.isLoading)
    }
}