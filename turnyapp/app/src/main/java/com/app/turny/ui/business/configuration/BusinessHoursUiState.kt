package com.app.turny.ui.business.configuration

data class BusinessHoursUiState(

    val days: List<BusinessHourUi> = emptyList(),

    val isLoading: Boolean = false,

    val isSaving: Boolean = false,

    val success: Boolean = false,

    val error: String? = null
)

data class BusinessHourUi(

    val diaSemana: Int,

    val shortName: String,

    val fullName: String,

    val enabled: Boolean,

    val startTime: String,

    val endTime: String,

    val breakEnabled: Boolean,

    val breakStart: String,

    val breakEnd: String,

    val expanded: Boolean = false
)