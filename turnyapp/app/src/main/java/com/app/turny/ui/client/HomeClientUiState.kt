package com.app.turny.ui.client

import com.app.turny.data.remote.dto.business.BusinessCardResponse

data class HomeClientUiState(

    val isLoading: Boolean = false,

    val businesses: List<BusinessCardResponse> = emptyList(),

    val userName: String = "",

    val error: String? = null
)