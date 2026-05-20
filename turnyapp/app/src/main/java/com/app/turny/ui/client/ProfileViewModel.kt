package com.app.turny.ui.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.repository.ProfileRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    private val repository =
        ProfileRepositoryImpl()

    private val _uiState =
        MutableStateFlow(ProfileUiState())

    val uiState: StateFlow<ProfileUiState> =
        _uiState

    init {

        loadProfile()
    }

    private fun loadProfile() {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true
            )

            try {

                val token =
                    sessionManager.getToken()

                if(token == null){

                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Sesión no encontrada"
                    )

                    return@launch
                }

                val profile =
                    repository.getClienteProfile(token)

                _uiState.value = _uiState.value.copy(

                    isLoading = false,

                    nombre = profile.nombre,

                    email = profile.email,

                    telefono = profile.telefono ?: ""
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(

                    isLoading = false,

                    error = e.message
                )
            }
        }
    }

    fun logout(
        onComplete: () -> Unit
    ) {

        viewModelScope.launch {

            sessionManager.clearSession()

            onComplete()
        }
    }
}