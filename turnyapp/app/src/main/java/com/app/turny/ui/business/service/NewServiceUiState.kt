package com.app.turny.ui.business.service

data class NewServiceUiState(

    val name: String = "",

    val description: String = "",

    val duration: String = "",

    val price: String = "",

    val category: String = "",

    val isLoading: Boolean = false,

    val success: Boolean = false,

    val error: String? = null
)