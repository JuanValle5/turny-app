package com.app.turny

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.domain.model.Role
import com.app.turny.domain.repository.AuthRepository
import com.app.turny.ui.auth.login.LoginViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Test

class LoginViewModelTest {
    //TEST 1 - Verifica que el usuario pueda escribir correctamente el correo en la pantalla de login.
    @Test
    fun emailShouldUpdateCorrectly() {

        val application = mockk<Application>(relaxed = true)

        val viewModel = LoginViewModel(application)

        viewModel.onEmailChange("usuario@gmail.com")

        assertEquals(
            "usuario@gmail.com",
            viewModel.uiState.value.email
        )
    }


    //TEST 2 - Comprueba que la contraseña ingresada se almacena correctamente.
    @Test
    fun passwordShouldUpdateCorrectly() {

        val application = mockk<Application>(relaxed = true)

        val viewModel = LoginViewModel(application)

        viewModel.onPasswordChange("123456")

        assertEquals(
            "123456",
            viewModel.uiState.value.password
        )
    }

    //TEST 3 - Verifica que la pantalla inicia vacía y sin errores.
    @Test
    fun initialStateShouldBeCorrect() {

        val application = mockk<Application>(relaxed = true)

        val viewModel = LoginViewModel(application)

        val state = viewModel.uiState.value

        assertEquals("", state.email)

        assertEquals("", state.password)

        assertEquals(false, state.isLoading)

        assertEquals(false, state.success)
    }

    //TEST 4 - Verificar que la contraseña cambia correctamente
    @Test
    fun password_updates_correctly() {

        val application = mockk<Application>(relaxed = true)

        val viewModel = LoginViewModel(application)

        viewModel.onPasswordChange("123456")

        assertEquals(
            "123456",
            viewModel.uiState.value.password
        )
    }

    //TEST 5 - Verificar múltiples cambios de email
    @Test
    fun last_email_value_is_preserved() {

        val application = mockk<Application>(relaxed = true)

        val viewModel = LoginViewModel(application)

        viewModel.onEmailChange("a@test.com")
        viewModel.onEmailChange("b@test.com")
        viewModel.onEmailChange("c@test.com")

        assertEquals(
            "c@test.com",
            viewModel.uiState.value.email
        )
    }


}