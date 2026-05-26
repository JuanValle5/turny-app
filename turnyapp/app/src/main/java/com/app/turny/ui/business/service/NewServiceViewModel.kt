package com.app.turny.ui.business.service

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.remote.dto.service.ServiceRequest
import com.app.turny.data.repository.ServiceRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewServiceViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        ServiceRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(NewServiceUiState())

    val uiState:
            StateFlow<NewServiceUiState> =
        _uiState

    fun onNameChange(value: String){

        _uiState.value =
            _uiState.value.copy(
                name = value
            )
    }

    fun onDescriptionChange(value: String){

        _uiState.value =
            _uiState.value.copy(
                description = value
            )
    }

    fun onDurationChange(value: String){

        _uiState.value =
            _uiState.value.copy(
                duration = value
            )
    }

    fun onPriceChange(value: String){

        _uiState.value =
            _uiState.value.copy(
                price = value
            )
    }

    fun onCategoryChange(value: String){

        _uiState.value =
            _uiState.value.copy(
                category = value
            )
    }

    fun createService() {

        viewModelScope.launch {

            try {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                    )

                val token =
                    sessionManager.getToken()

                if(token == null){

                    _uiState.value =
                        _uiState.value.copy(
                            error = "No session",
                            isLoading = false
                        )

                    return@launch
                }

                repository.createService(

                    token = token,

                    request = ServiceRequest(

                        nombre =
                            _uiState.value.name,

                        descripcion =
                            _uiState.value.description,

                        duracion =
                            _uiState.value
                                .duration
                                .toInt(),

                        precio =
                            _uiState.value
                                .price
                                .toDouble(),

                        precioDesde = false,

                        categoria =
                            _uiState.value.category,

                        imagenUrl = null,

                        orden = 1
                    )
                )

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        success = true
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