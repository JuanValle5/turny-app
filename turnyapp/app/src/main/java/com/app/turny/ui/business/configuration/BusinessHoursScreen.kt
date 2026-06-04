package com.app.turny.ui.business.configuration

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PrimaryBlue = Color(0xFF0D95E8)
private val LightBlue = Color(0xFFEAF7FD)
private val LightBlueIcon = Color(0xFFDDF2FD)

private val BorderGray = Color(0xFFD9E1EA)
private val ScreenGray = Color(0xFFF4F6F8)
private val DisabledCard = Color(0xFFF1F4F7)

private val TextPrimary = Color(0xFF101828)
private val TextSecondary = Color(0xFF667085)

private val AvailableHours = buildList {

    for(hour in 0..22){

        add(
            String.format(
                "%02d:00",
                hour
            )
        )

        if(hour < 22){

            add(
                String.format(
                    "%02d:30",
                    hour
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessHoursScreen(

    onBack: () -> Unit,

    viewModel: BusinessHoursViewModel =
        androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val uiState by
    viewModel.uiState.collectAsState()

    val context =
        LocalContext.current
    LaunchedEffect(
        uiState.success
    ) {

        if(uiState.success){

            Toast.makeText(

                context,

                "Horarios guardados",

                Toast.LENGTH_SHORT

            ).show()
        }
    }
    LaunchedEffect(
        uiState.error
    ) {

        uiState.error?.let {

            Toast.makeText(

                context,

                it,

                Toast.LENGTH_LONG

            ).show()
        }
    }

    Scaffold(
        containerColor = ScreenGray,
        bottomBar = {
            Surface(
                color = Color.White,
                shadowElevation = 8.dp
            ) {

                Box(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    )
                ) {

                    Button(
                        onClick = {
                            viewModel.saveHours()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryBlue
                        ),
                        enabled = !uiState.isSaving
                    ) {

                        if(uiState.isSaving){

                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                strokeWidth = 2.dp
                            )

                        }else{

                            Text(
                                text = "Guardar horarios"
                            )
                        }
                    }
                }
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        modifier = Modifier.size(40.dp),
                        shape = CircleShape,
                        color = Color(0xFFE9EEF4)
                    ) {

                        IconButton(

                            onClick = onBack
                        ){

                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {

                        Text(
                            text = "Horarios de atención",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextPrimary
                        )

                        Text(
                            text = "Configura cuando atiendes clientes",
                            fontSize = 14.sp,
                            color = TextSecondary
                        )
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = LightBlue
                    ),
                    border = BorderStroke(
                        1.dp,
                        Color(0xFFBDE5F8)
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(CircleShape)
                                .background(LightBlueIcon),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.AccessTime,
                                contentDescription = null,
                                tint = PrimaryBlue
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column {

                            Text(
                                text =
                                    uiState.days.count {

                                        it.enabled
                                    }.toString(),
                                fontSize = 34.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "días abiertos por semana",
                                fontSize = 15.sp,
                                color = TextSecondary
                            )
                        }
                    }
                }
            }

            itemsIndexed(uiState.days) { index, day ->

                DayCard(

                    day = day,

                    onSwitch = {

                        viewModel.toggleDay(
                            index
                        )
                    },

                    onExpand = {

                        viewModel.toggleExpand(
                            index
                        )
                    },

                    onStartTimeChange = {

                        viewModel.updateStartTime(
                            index,
                            it
                        )
                    },

                    onEndTimeChange = {

                        viewModel.updateEndTime(
                            index,
                            it
                        )
                    },

                    onBreakToggle = {

                        viewModel.toggleBreak(
                            index
                        )
                    },

                    onBreakStartChange = {

                        viewModel.updateBreakStart(
                            index,
                            it
                        )
                    },

                    onBreakEndChange = {

                        viewModel.updateBreakEnd(
                            index,
                            it
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun DayCard(

    day: BusinessHourUi,

    onSwitch: () -> Unit,

    onExpand: () -> Unit,

    onStartTimeChange: (String) -> Unit,

    onEndTimeChange: (String) -> Unit,

    onBreakToggle: () -> Unit,

    onBreakStartChange: (String) -> Unit,

    onBreakEndChange: (String) -> Unit
) {

    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor =
                if (day.enabled) Color.White
                else DisabledCard
        ),
        border = BorderStroke(
            1.dp,
            BorderGray
        )
    ) {

        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(
                            if (day.enabled)
                                Color(0xFFE7F4FD)
                            else
                                Color(0xFFECEFF3)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = day.shortName,
                        color =
                            if (day.enabled)
                                PrimaryBlue
                            else
                                Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = day.fullName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary
                    )

                    Text(
                        text =
                            if (day.enabled)
                                "${day.startTime} - ${day.endTime}"
                            else
                                "Cerrado",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }

                Switch(
                    checked = day.enabled,
                    onCheckedChange = {
                        onSwitch()
                    }
                )

                if (day.enabled) {

                    IconButton(
                        onClick = onExpand
                    ) {

                        Icon(
                            imageVector =
                                if (day.expanded)
                                    Icons.Default.KeyboardArrowUp
                                else
                                    Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }
            }

            AnimatedVisibility(day.enabled && day.expanded) {

                Column {

                    HorizontalDivider(
                        color = BorderGray
                    )

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Horario de atención",
                            color = TextSecondary,
                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            TimeDropdown(

                                selectedTime =
                                    day.startTime,

                                onTimeSelected =
                                    onStartTimeChange
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "a",
                                fontSize = 18.sp
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            TimeDropdown(

                                selectedTime =
                                    day.endTime,

                                onTimeSelected =
                                    onEndTimeChange
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.Coffee,
                                contentDescription = null,
                                tint = TextSecondary
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Hora de descanso",
                                fontSize = 16.sp
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Switch(

                                checked =
                                    day.breakEnabled,

                                onCheckedChange = {

                                    onBreakToggle()
                                }
                            )

                            AnimatedVisibility(
                                visible = day.breakEnabled
                            ) {

                                Column {

                                    Spacer(
                                        modifier = Modifier.height(16.dp)
                                    )

                                    Text(
                                        text = "Horario de descanso"
                                    )

                                    Spacer(
                                        modifier = Modifier.height(12.dp)
                                    )

                                    Row {

                                        TimeDropdown(

                                            selectedTime =
                                                day.breakStart,

                                            onTimeSelected =
                                                onBreakStartChange
                                        )

                                        Spacer(
                                            modifier = Modifier.width(10.dp)
                                        )

                                        Text(
                                            text = "a",
                                            modifier =
                                                Modifier.align(
                                                    Alignment.CenterVertically
                                                )
                                        )

                                        Spacer(
                                            modifier = Modifier.width(10.dp)
                                        )

                                        TimeDropdown(

                                            selectedTime =
                                                day.breakEnd,

                                            onTimeSelected =
                                                onBreakEndChange
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.ContentCopy,
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Copiar a días laborables"
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
private fun TimeDropdown(

    selectedTime: String,

    onTimeSelected: (String) -> Unit
) {

    var expanded by remember {

        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(

        expanded = expanded,

        onExpandedChange = {

            expanded = !expanded
        }
    ) {

        OutlinedTextField(

            value = selectedTime,

            onValueChange = {},

            readOnly = true,

            modifier = Modifier
                .width(140.dp)
                .menuAnchor(),

            trailingIcon = {

                ExposedDropdownMenuDefaults
                    .TrailingIcon(
                        expanded = expanded
                    )
            }
        )

        ExposedDropdownMenu(

            expanded = expanded,

            onDismissRequest = {

                expanded = false
            }
        ) {

            AvailableHours.forEach {

                DropdownMenuItem(

                    text = {

                        Text(it)
                    },

                    onClick = {

                        onTimeSelected(it)

                        expanded = false
                    }
                )
            }
        }
    }
}