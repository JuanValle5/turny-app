package com.app.turny.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*

enum class AppointmentStatus {
    PENDING,
    COMPLETED,
    CONFIRMED
}


@Composable
fun AppointmentBusinessCard(
    serviceName: String,
    clientName: String,
    hour: String,
    duration: String,
    status: AppointmentStatus,
    modifier: Modifier = Modifier,
    onComplete: () -> Unit = {},
    onCancel: () -> Unit = {}
) {

    var expanded by remember { mutableStateOf(false) }

    val statusConfig = when (status) {

        AppointmentStatus.PENDING -> Triple(
            "Pendiente",
            Color(0xFFF7F1E3),
            Color(0xFFE0A91A)
        )

        AppointmentStatus.COMPLETED -> Triple(
            "Completada",
            Color(0xFFE7F7ED),
            Color(0xFF2DBE60)
        )

        AppointmentStatus.CONFIRMED -> Triple(
            "Confirmada",
            Color(0xFFE7F1FF),
            Color(0xFF0D8BE5)
        )
    }

    val (statusText, statusBackground, statusColor) = statusConfig

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFFD9DDE1),
                shape = RoundedCornerShape(24.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(18.dp)
    ) {

        Column {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                Box {

                    IconButton(
                        onClick = {
                            expanded = true
                        }
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = null,
                            tint = Color(0xFF5F6672)
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {

                        DropdownMenuItem(
                            text = {
                                Text("Completar")
                            },
                            onClick = {
                                expanded = false
                                onComplete()
                            }
                        )

                        DropdownMenuItem(
                            text = {
                                Text("Cancelar")
                            },
                            onClick = {
                                expanded = false
                                onCancel()
                            }
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Hora
                Box(
                    modifier = Modifier
                        .size(width = 88.dp, height = 120.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(Color(0xFFDDEAF4)),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = hour.split(":")[0],
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D8BE5)
                        )

                        Text(
                            text = ":" + hour.split(":")[1],
                            fontSize = 18.sp,
                            color = Color(0xFF0D8BE5)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))

                // Información
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = serviceName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.PersonOutline,
                            contentDescription = null,
                            tint = Color(0xFF5F6672),
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = clientName,
                            fontSize = 16.sp,
                            color = Color(0xFF5F6672)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.AccessTime,
                            contentDescription = null,
                            tint = Color(0xFF5F6672),
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = duration,
                            fontSize = 16.sp,
                            color = Color(0xFF5F6672)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Estado
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(statusBackground)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(50))
                                .background(statusColor)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = statusText,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = statusColor
                        )
                    }
                }
            }
        }
    }
}