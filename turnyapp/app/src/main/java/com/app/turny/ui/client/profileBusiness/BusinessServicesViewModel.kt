package com.app.turny.ui.client.profileBusiness

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.remote.dto.service.ServiceResponse
import com.app.turny.data.repository.ServiceRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class BusinessServicesUiState(

    val services:
    List<ServiceResponse> = emptyList(),

    val isLoading: Boolean = false,

    val error: String? = null
)

class BusinessServicesViewModel :
    ViewModel() {

    private val repository =
        ServiceRepositoryImpl()

    private val _uiState =
        MutableStateFlow(
            BusinessServicesUiState()
        )

    val uiState:
            StateFlow<BusinessServicesUiState> =
        _uiState

    fun loadServices(
        businessId: String
    ) {

        viewModelScope.launch {

            try {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                    )

                val services =
                    repository.getServices(
                        businessId
                    )

                _uiState.value =
                    _uiState.value.copy(

                        services = services,

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
}