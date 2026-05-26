package com.app.turny.ui.business.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.repository.BusinessAppointmentRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class HomeBusinessViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    private val appointmentRepository =
        BusinessAppointmentRepositoryImpl()

    private val _uiState =
        MutableStateFlow(HomeBusinessUiState())

    val uiState: StateFlow<HomeBusinessUiState> =
        _uiState

    init {
        loadDashboard()
    }

    fun selectDate(
        date: LocalDate
    ) {

        _uiState.value =
            _uiState.value.copy(
                selectedDate = date
            )

        loadDashboard(date)
    }
    private fun loadDashboard(
        date: LocalDate = LocalDate.now()
    ) {

        viewModelScope.launch {

            try {

                val userName =
                    sessionManager.getUserName()
                        ?: ""

                val token =
                    sessionManager.getToken()

                if(token == null){

                    _uiState.value =
                        _uiState.value.copy(
                            error = "No session"
                        )

                    return@launch
                }

                val today =
                    date.toString()

                val appointments =
                    appointmentRepository
                        .getAppointments(

                            token = token,

                            fecha = today
                        )

                val confirmed =
                    appointments.count {

                        it.estado == "CONFIRMADA"
                    }

                val pending =
                    appointments.count {

                        it.estado == "PENDIENTE"
                    }

                _uiState.value =
                    _uiState.value.copy(

                        userName = userName,

                        selectedDate = date,

                        appointments = appointments,

                        totalAppointments =
                            appointments.size,

                        confirmedAppointments =
                            confirmed,

                        pendingAppointments =
                            pending
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(
                        error = e.message
                    )
            }
        }
    }
}