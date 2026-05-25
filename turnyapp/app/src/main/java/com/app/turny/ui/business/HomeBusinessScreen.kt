package com.app.turny.ui.business

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.turny.ui.components.BottomNavItem
import com.app.turny.ui.components.BottomNavigationBar
import com.app.turny.ui.components.structure.AppHeader

private val GrayBg = Color(0xFFF5F6FA)
private val White = Color.White
private val PrimaryBlue = Color(0xFF3B82F6)
private val BorderGray = Color(0xFFE5E7EB)
private val TextGray = Color(0xFF6B7280)

data class DayItem(
    val dayName: String,
    val number: String,
    val selected: Boolean = false
)

@Composable
fun HomeBusinessScreen(
    onNavigateToConfiguration: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBg)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            // CONTENT
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .padding(top = 14.dp)
            ) {

                Card(
                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(28.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = White
                    ),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Column {

                        // HEADER
                        AppHeader(
                            userName = "Andy Rengifo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 18.dp,
                                    vertical = 18.dp
                                )
                        )

                        HorizontalDivider(
                            color = BorderGray
                        )

                        Column(
                            modifier = Modifier
                                .padding(18.dp)
                        ) {

                            GreetingSection()

                            Spacer(
                                modifier = Modifier.height(22.dp)
                            )

                            StatsSection()

                            Spacer(
                                modifier = Modifier.height(28.dp)
                            )

                            CalendarSection()

                            Spacer(
                                modifier = Modifier.height(28.dp)
                            )

                            TodayAppointmentsSection()
                        }
                    }
                }
            }

            // FOOTER
            BottomNavigationBar(

                selectedItem = BottomNavItem.HOME,

                onHomeClick = {},

                onAgendaClick = {},

                onServicesClick = {},

                onProfileClick = {

                    onNavigateToConfiguration()
                }
            )
        }

        // FAB
        FloatingActionButton(

            onClick = {},

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 22.dp,
                    bottom = 82.dp
                ),

            containerColor = PrimaryBlue,

            shape = CircleShape
        ) {

            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = null,
                tint = White
            )
        }
    }
}

@Composable
fun GreetingSection() {

    Text(
        text = "Buen día!",
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = "Jueves, 5 de febrero",
        style = MaterialTheme.typography.bodyMedium,
        color = TextGray
    )
}

@Composable
fun StatsSection() {

    Row(
        horizontalArrangement =
            Arrangement.spacedBy(12.dp)
    ) {

        StatCard(
            icon = Icons.Outlined.CalendarMonth,
            value = "5",
            label = "Total"
        )

        StatCard(
            icon = Icons.Outlined.CheckCircle,
            value = "2",
            label = "Confirmados"
        )

        StatCard(
            icon = Icons.Outlined.AccessTime,
            value = "2",
            label = "Pendientes"
        )
    }
}

@Composable
fun StatCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    label: String
) {

    Card(
        modifier = Modifier
            .height(110.dp)
            .width(98.dp),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )

            Text(
                text = value,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = TextGray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CalendarSection() {

    val days = listOf(

        DayItem("Lun", "2"),
        DayItem("Mar", "3"),
        DayItem("Mié", "4"),
        DayItem("Jue", "5", true),
        DayItem("Vie", "6"),
        DayItem("Sáb", "7"),
        DayItem("Dom", "8")
    )

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier
                .padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector =
                        Icons.Outlined.ChevronLeft,
                    contentDescription = null
                )

                Text(
                    text = "Febrero 2026",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                Icon(
                    imageVector =
                        Icons.Outlined.ChevronRight,
                    contentDescription = null
                )
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            LazyRow(
                horizontalArrangement =
                    Arrangement.spacedBy(14.dp)
            ) {

                items(days) { day ->

                    Column(
                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = day.dayName,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .background(

                                    if(day.selected)
                                        PrimaryBlue

                                    else
                                        Color.Transparent
                                ),

                            contentAlignment =
                                Alignment.Center
                        ) {

                            Text(
                                text = day.number,

                                color =

                                    if(day.selected)
                                        White

                                    else
                                        Color.Black,

                                fontSize = 26.sp,

                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TodayAppointmentsSection() {

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text = "Citas – hoy",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            Text(
                text = "5 citas",
                color = TextGray
            )
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        AppointmentBusinessCard()
    }
}

@Composable
fun AppointmentBusinessCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(
                        width = 82.dp,
                        height = 98.dp
                    )
                    .clip(RoundedCornerShape(18.dp))
                    .background(PrimaryBlue),

                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "09",
                        color = White,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = ":00",
                        color = White,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Corte de cabello",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Carlos Mendoza",
                    color = TextGray
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =
                            Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = TextGray,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )

                    Text(
                        text = "30 min",
                        color = TextGray
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = PrimaryBlue,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(White)
                        .padding(
                            horizontal = 18.dp,
                            vertical = 10.dp
                        )
                ) {

                    Text(
                        text = "Confirmado",
                        color = PrimaryBlue,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}