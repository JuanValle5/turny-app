package com.app.turny.ui.client

data class ProfileUiState(

    val isLoading: Boolean = false,

    val nombre: String = "",

    val email: String = "",

    val telefono: String = "",

    val error: String? = null
)