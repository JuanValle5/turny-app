package com.app.turny.ui.business.configuration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.remote.dto.business.BusinessHourRequest
import com.app.turny.data.repository.BusinessHourRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BusinessHoursViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        BusinessHourRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(
            BusinessHoursUiState()
        )

    val uiState:
            StateFlow<BusinessHoursUiState> =
        _uiState

    init {

        loadHours()
    }

    fun loadHours() {

        viewModelScope.launch {

            try {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                    )

                val businessId =
                    sessionManager.getProfileId()

                if (businessId == null) {

                    _uiState.value =
                        _uiState.value.copy(
                            error = "No business id",
                            isLoading = false
                        )

                    return@launch
                }

                val response =
                    repository.getBusinessHours(
                        businessId
                    )

                val days =
                    response.map {

                        BusinessHourUi(

                            diaSemana =
                                it.diaSemana,

                            shortName =
                                getShortName(
                                    it.diaSemana
                                ),

                            fullName =
                                it.diaNombre,

                            enabled =
                                it.abierto,

                            startTime =
                                it.horaApertura
                                    ?: "09:00",

                            endTime =
                                it.horaCierre
                                    ?: "18:00",

                            breakEnabled =
                                it.descansoInicio != null,

                            breakStart =
                                it.descansoInicio
                                    ?: "13:00",

                            breakEnd =
                                it.descansoFin
                                    ?: "14:00"
                        )
                    }

                _uiState.value =
                    _uiState.value.copy(

                        days = days,

                        isLoading = false
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(

                        error = e.message,

                        isLoading = false
                    )
            }
        }
    }

    fun saveHours() {

        viewModelScope.launch {

            try {

                val token =
                    sessionManager.getToken()
                        ?: return@launch
                for(day in _uiState.value.days){

                    if(
                        day.enabled &&
                        day.startTime >= day.endTime
                    ){

                        _uiState.value =
                            _uiState.value.copy(

                                error =
                                    "${day.fullName}: la apertura debe ser menor que el cierre"
                            )

                        return@launch
                    }
                }
                for(day in _uiState.value.days){

                    if(
                        day.breakEnabled &&
                        day.breakStart >= day.breakEnd
                    ){

                        _uiState.value =
                            _uiState.value.copy(

                                error =
                                    "${day.fullName}: horario de descanso inválido"
                            )

                        return@launch
                    }
                }
                val request =
                    _uiState.value.days.map {

                        BusinessHourRequest(

                            diaSemana =
                                it.diaSemana,

                            abierto =
                                it.enabled,

                            horaApertura =
                                if(it.enabled)
                                    it.startTime
                                else
                                    null,

                            horaCierre =
                                if(it.enabled)
                                    it.endTime
                                else
                                    null,

                            descansoInicio =
                                if(it.breakEnabled)
                                    it.breakStart
                                else
                                    null,

                            descansoFin =
                                if(it.breakEnabled)
                                    it.breakEnd
                                else
                                    null
                        )
                    }
                _uiState.value =
                    _uiState.value.copy(
                        isSaving = true,
                        error = null,
                        success = false
                    )
                repository.saveBusinessHours(

                    token = token,

                    request = request
                )

                _uiState.value =
                    _uiState.value.copy(

                        success = true,

                        isSaving = false
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(

                        error =
                            e.message
                                ?: "Error al guardar",

                        isSaving = false
                    )
            }
        }
    }

    fun toggleDay(
        index: Int
    ) {

        val updated =
            _uiState.value.days.toMutableList()

        updated[index] =
            updated[index].copy(
                enabled =
                    !updated[index].enabled
            )

        _uiState.value =
            _uiState.value.copy(
                days = updated
            )
    }

    fun toggleExpand(
        index: Int
    ) {

        val updated =
            _uiState.value.days.toMutableList()

        updated[index] =
            updated[index].copy(
                expanded =
                    !updated[index].expanded
            )

        _uiState.value =
            _uiState.value.copy(
                days = updated
            )
    }

    fun toggleBreak(
        index: Int
    ) {

        val updated =
            _uiState.value.days.toMutableList()

        updated[index] =
            updated[index].copy(
                breakEnabled =
                    !updated[index].breakEnabled
            )

        _uiState.value =
            _uiState.value.copy(
                days = updated
            )
    }

    fun updateStartTime(
        index: Int,
        value: String
    ) {

        updateDay(index) {

            copy(
                startTime = value
            )
        }
    }

    fun updateEndTime(
        index: Int,
        value: String
    ) {

        updateDay(index) {

            copy(
                endTime = value
            )
        }
    }

    fun updateBreakStart(
        index: Int,
        value: String
    ) {

        updateDay(index) {

            copy(
                breakStart = value
            )
        }
    }

    fun updateBreakEnd(
        index: Int,
        value: String
    ) {

        updateDay(index) {

            copy(
                breakEnd = value
            )
        }
    }

    private fun updateDay(
        index: Int,
        update: BusinessHourUi.() -> BusinessHourUi
    ) {

        val updated =
            _uiState.value.days.toMutableList()

        updated[index] =
            updated[index].update()

        _uiState.value =
            _uiState.value.copy(
                days = updated
            )
    }

    private fun getShortName(
        day: Int
    ): String {

        return when(day){

            0 -> "Dom"
            1 -> "Lun"
            2 -> "Mar"
            3 -> "Mié"
            4 -> "Jue"
            5 -> "Vie"
            6 -> "Sáb"

            else -> ""
        }
    }
}