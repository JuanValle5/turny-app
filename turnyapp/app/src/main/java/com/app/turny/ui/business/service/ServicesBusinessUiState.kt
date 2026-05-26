package com.app.turny.ui.business.service

import com.app.turny.data.remote.dto.service.ServiceResponse

data class ServicesBusinessUiState(

    val services:
    List<ServiceResponse> = emptyList(),

    val userName: String = "",

    val isLoading: Boolean = false,

    val error: String? = null
)