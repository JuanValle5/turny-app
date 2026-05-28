package com.app.turny.ui.client.profileBusiness

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.remote.dto.service.ServiceResponse
import com.app.turny.data.repository.BusinessRepositoryImpl
import com.app.turny.data.repository.ServiceRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class BusinessServicesUiState(

    val businessName: String = "",

    val businessCategory: String = "",

    val rating: String = "",

    val reviews: Int = 0,

    val services:
    List<ServiceResponse> = emptyList(),

    val isLoading: Boolean = false,

    val error: String? = null
)

class BusinessServicesViewModel :
    ViewModel() {

    private val repository =
        ServiceRepositoryImpl()

    private val businessRepository =
        BusinessRepositoryImpl()

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

                val businesses =
                    businessRepository.getBusinesses()

                val business =
                    businesses.find {

                        it.negocioId == businessId
                    }

                _uiState.value =
                    _uiState.value.copy(

                        businessName =
                            business?.nombre ?: "",

                        businessCategory =
                            business?.categoria ?: "",

                        rating =
                            business?.rating?.toString() ?: "0.0",

                        reviews =
                            business?.totalResenas ?: 0,

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