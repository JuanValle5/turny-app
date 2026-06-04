package com.app.turny.ui.business.configuration

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

data class DaySchedule(
    val shortName: String,
    val fullName: String,
    val enabled: Boolean,
    val startTime: String,
    val endTime: String,
    val breakEnabled: Boolean = false,
    val expanded: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessHoursScreen() {

    var days by remember {
        mutableStateOf(
            listOf(
                DaySchedule(
                    shortName = "Dom",
                    fullName = "Domingo",
                    enabled = false,
                    startTime = "",
                    endTime = ""
                ),
                DaySchedule(
                    shortName = "Lun",
                    fullName = "Lunes",
                    enabled = true,
                    startTime = "09:00",
                    endTime = "18:00",
                    expanded = true
                ),
                DaySchedule(
                    shortName = "Mar",
                    fullName = "Martes",
                    enabled = true,
                    startTime = "09:00",
                    endTime = "18:00"
                ),
                DaySchedule(
                    shortName = "Mié",
                    fullName = "Miércoles",
                    enabled = true,
                    startTime = "09:00",
                    endTime = "18:00"
                ),
                DaySchedule(
                    shortName = "Jue",
                    fullName = "Jueves",
                    enabled = true,
                    startTime = "09:00",
                    endTime = "18:00"
                ),
                DaySchedule(
                    shortName = "Vie",
                    fullName = "Viernes",
                    enabled = true,
                    startTime = "09:00",
                    endTime = "18:00"
                ),
                DaySchedule(
                    shortName = "Sáb",
                    fullName = "Sábado",
                    enabled = false,
                    startTime = "",
                    endTime = ""
                )
            )
        )
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
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryBlue
                        )
                    ) {
                        Text(
                            text = "Guardar horarios",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
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
                            onClick = {}
                        ) {

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
                                text = "5",
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

            itemsIndexed(days) { index, day ->

                DayCard(
                    day = day,
                    onSwitch = {

                        days = days.toMutableList().apply {

                            this[index] = day.copy(
                                enabled = !day.enabled
                            )
                        }
                    },
                    onExpand = {

                        days = days.toMutableList().apply {

                            this[index] = day.copy(
                                expanded = !day.expanded
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun DayCard(
    day: DaySchedule,
    onSwitch: () -> Unit,
    onExpand: () -> Unit
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

                            TimeField("09:00")

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "a",
                                fontSize = 18.sp
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            TimeField("18:00")
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
                                checked = false,
                                onCheckedChange = {}
                            )
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

@Composable
private fun TimeField(
    time: String
) {

    Row(
        modifier = Modifier
            .width(140.dp)
            .border(
                1.dp,
                BorderGray,
                RoundedCornerShape(12.dp)
            )
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = time,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = null
        )
    }
}