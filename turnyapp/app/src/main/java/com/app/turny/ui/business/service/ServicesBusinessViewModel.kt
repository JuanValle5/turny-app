package com.app.turny.ui.business.service

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.turny.data.local.SessionManager
import com.app.turny.data.repository.ServiceRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ServicesBusinessViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        ServiceRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(
            ServicesBusinessUiState()
        )

    val uiState:
            StateFlow<ServicesBusinessUiState> =
        _uiState

    fun loadServices() {



        viewModelScope.launch {


            try {
                val businessId =
                    sessionManager.getProfileId()

                println("BUSINESS ID: $businessId")

                if(businessId == null){

                    _uiState.value =
                        _uiState.value.copy(
                            error = "No business id"
                        )

                    return@launch
                }
                val services =
                    repository.getServices(
                        businessId
                    )

                val userName =
                    sessionManager.getUserName()
                        ?: ""

                println("USERNAME: $userName")

                _uiState.value =
                    _uiState.value.copy(

                        services = services,

                        userName = userName
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