package com.app.turny.ui.business

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.repository.BusinessProfileRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ConfigurationBusinessViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val sessionManager =
        SessionManager(application)

    private val repository =
        BusinessProfileRepositoryImpl()

    private val _uiState =
        MutableStateFlow(
            ConfigurationBusinessUiState()
        )

    val uiState:
            StateFlow<ConfigurationBusinessUiState> =
        _uiState

    init {

        loadProfile()
    }

    private fun loadProfile() {

        viewModelScope.launch {

            try {

                val token =
                    sessionManager.getToken()

                if(token == null){

                    _uiState.value =
                        _uiState.value.copy(
                            error = "No session"
                        )

                    return@launch
                }

                val profile =
                    repository.getProfile(token)

                _uiState.value =
                    _uiState.value.copy(

                        ownerName =
                            profile.nombre,

                        businessName =
                            profile.nombreNegocio,

                        email =
                            profile.email,

                        businessEmail =
                            profile.emailNegocio ?: "",

                        phone =
                            profile.telefono,

                        whatsapp =
                            profile.whatsapp ?: "",

                        address =
                            profile.direccion,

                        city =
                            profile.ciudad ?: "",

                        category =
                            profile.categoria,

                        website =
                            profile.website ?: "",

                        description =
                            profile.descripcion ?: "",

                        businessCode =
                            profile.codigo,

                        rating =
                            profile.rating ?: 0.0,

                        reviews =
                            profile.totalResenas ?: 0,

                        verified =
                            profile.verificado ?: false
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(
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