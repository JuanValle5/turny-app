package com.app.turny.ui.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.repository.AppointmentRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppointmentsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        AppointmentRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(AppointmentsUiState())

    val uiState: StateFlow<AppointmentsUiState> =
        _uiState

    init {

        loadAppointments()
    }

    fun onTabSelected(
        tab: AppointmentsTab
    ) {

        _uiState.value =
            _uiState.value.copy(
                selectedTab = tab
            )
    }

    private fun loadAppointments() {

        viewModelScope.launch {

            _uiState.value =
                _uiState.value.copy(
                    isLoading = true
                )

            try {

                val token =
                    sessionManager.getToken()

                val userName =
                    sessionManager.getUserName() ?: ""

                if(token == null){

                    _uiState.value =
                        _uiState.value.copy(
                            isLoading = false,
                            error = "No session"
                        )

                    return@launch
                }

                val appointments =
                    repository.getMyAppointments(
                        token
                    )

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        appointments = appointments,

                        userName = userName
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        error = e.message
                    )
            }
        }
    }
}