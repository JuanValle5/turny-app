package com.app.turny.ui.client.profileBusiness

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.remote.dto.service.ServiceResponse
import com.app.turny.data.repository.BusinessRepositoryImpl
import com.app.turny.data.repository.FavoriteRepositoryImpl
import com.app.turny.data.repository.ServiceRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class BusinessServicesUiState(

    val businessName: String = "",

    val businessCategory: String = "",

    val rating: String = "",

    val reviews: Int = 0,

    val isFavorite: Boolean = false,

    val services:
    List<ServiceResponse> = emptyList(),

    val description: String = "",

    val address: String = "",

    val phone: String = "",

    val email: String = "",

    val isLoading: Boolean = false,

    val error: String? = null
)

class BusinessServicesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    private val repository =
        ServiceRepositoryImpl()

    private val businessRepository =
        BusinessRepositoryImpl()

    private val favoriteRepository =
        FavoriteRepositoryImpl()

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
                    businessRepository
                        .getBusinesses()

                val business =
                    businesses.find {

                        it.negocioId ==
                                businessId
                    }

                val token =
                    sessionManager.getToken()
                        ?: ""

                val favoriteResponse =
                    favoriteRepository.checkFavorite(

                        token = token,

                        negocioId = businessId
                    )

                _uiState.value =
                    _uiState.value.copy(

                        businessName =
                            business?.nombre ?: "",

                        businessCategory =
                            business?.categoria ?: "",

                        rating =
                            business?.rating
                                ?.toString()
                                ?: "0.0",

                        reviews =
                            business?.totalResenas
                                ?: 0,

                        isFavorite =
                            favoriteResponse
                                .esFavorito,

                        description = "Sin informacion",

                        address =
                            business?.direccion ?: "",

                        phone = "Sin informacion",

                        email = "Sin informacion",

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

    fun toggleFavorite(
        businessId: String
    ) {

        viewModelScope.launch {

            try {

                val token =
                    sessionManager.getToken()
                        ?: return@launch

                val response =
                    favoriteRepository
                        .toggleFavorite(

                            token = token,

                            negocioId = businessId
                        )

                _uiState.value =
                    _uiState.value.copy(

                        isFavorite =
                            response.esFavorito
                    )

            } catch (_: Exception) {

            }
        }
    }
}