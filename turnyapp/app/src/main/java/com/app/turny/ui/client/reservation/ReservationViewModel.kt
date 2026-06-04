package com.app.turny.ui.client.reservation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.remote.dto.appointment.CreateAppointmentRequest
import com.app.turny.data.repository.AppointmentRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.time.LocalDate

class ReservationViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        AppointmentRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(
            ReservationUiState()
        )

    val uiState:
            StateFlow<ReservationUiState> =
        _uiState

    fun selectDate(
        date: LocalDate
    ) {

        _uiState.value =
            _uiState.value.copy(
                selectedDate = date
            )
    }

    fun selectHour(
        hour: String
    ) {

        _uiState.value =
            _uiState.value.copy(
                selectedHour = hour
            )
    }

    fun onNotesChange(
        notes: String
    ) {

        _uiState.value =
            _uiState.value.copy(
                notes = notes
            )
    }

    fun loadSlots(

        businessId: String,

        serviceId: String
    ) {

        viewModelScope.launch {

            try {

                val slots =
                    repository.getSlots(

                        negocioId =
                            businessId,

                        servicioId =
                            serviceId,

                        fecha =
                            _uiState.value
                                .selectedDate
                                .toString()
                    )

                _uiState.value =
                    _uiState.value.copy(
                        slots = slots
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(
                        error = e.message
                    )
            }
        }
    }

    fun createAppointment(

        businessId: String,

        serviceId: String
    ) {

        viewModelScope.launch {

            try {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                    )

                val token =
                    sessionManager.getToken()
                        ?: return@launch

                repository.createAppointment(


                    token = token,

                    request =
                        CreateAppointmentRequest(

                            negocioId =
                                businessId,

                            servicioId =
                                serviceId,

                            fecha =
                                _uiState.value
                                    .selectedDate
                                    .toString(),

                            hora =
                                _uiState.value
                                    .selectedHour,

                            notasCliente =
                                _uiState.value
                                    .notes
                        )
                )

                loadSlots(

                    businessId = businessId,

                    serviceId = serviceId
                )

                _uiState.value =
                    _uiState.value.copy(

                        success = true,

                        isLoading = false
                    )

            } catch (e: HttpException) {

                _uiState.value =
                    _uiState.value.copy(

                        error =
                            when(e.code()){

                                409 ->
                                    "Horario no disponible"

                                400 ->
                                    "Datos inválidos"

                                403 ->
                                    "No autorizado"

                                else ->
                                    "Error ${e.code()}"
                            },

                        isLoading = false
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(

                        error =
                            e.message
                                ?: "Error desconocido",

                        isLoading = false
                    )
            }
        }
    }
}