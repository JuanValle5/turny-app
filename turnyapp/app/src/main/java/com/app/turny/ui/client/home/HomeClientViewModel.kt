package com.app.turny.ui.client.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.app.turny.data.local.SessionManager
import androidx.lifecycle.viewModelScope
import com.app.turny.data.repository.BusinessRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeClientViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        BusinessRepositoryImpl()

    private val sessionManager =
        SessionManager(application)

    private val _uiState =
        MutableStateFlow(HomeClientUiState())

    private val _searchedBusinessId =
        MutableStateFlow<String?>(null)

    val searchedBusinessId:
            StateFlow<String?> =
        _searchedBusinessId

    val uiState: StateFlow<HomeClientUiState> =
        _uiState

    init {

        loadBusinesses()
    }

    fun searchBusinessByCode(
        code: String
    ) {

        viewModelScope.launch {

            try {

                val business =
                    repository
                        .getBusinessByCode(
                            code
                        )

                _searchedBusinessId.value =
                    business.negocioId

            } catch (_: Exception) {

                _searchedBusinessId.value =
                    "ERROR"
            }
        }
    }
    fun clearSearchResult() {

        _searchedBusinessId.value = null
    }

    private fun loadBusinesses() {

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true
            )

            try {

                val businesses =
                    repository.getBusinesses()
                val userName =
                    sessionManager.getUserName() ?: ""

                _uiState.value = _uiState.value.copy(

                    isLoading = false,

                    businesses = businesses,
                    userName = userName
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(

                    isLoading = false,

                    error = e.message
                )
            }
        }
    }
}