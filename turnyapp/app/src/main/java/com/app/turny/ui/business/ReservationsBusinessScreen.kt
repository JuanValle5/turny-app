package com.app.turny.ui.business

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ContentCut
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.app.turny.ui.components.BottomNavItem
import com.app.turny.ui.components.BottomNavigationBar
import com.app.turny.ui.theme.BorderGray
import com.app.turny.ui.theme.GrayBg
import com.app.turny.ui.theme.PrimaryBlue
import com.app.turny.ui.theme.RedHard
import com.app.turny.ui.theme.White
import com.app.turny.ui.theme.YellowAccent
import com.app.turny.ui.theme.FreshGreen

@Composable
fun ReservationsBusinessScreen() {

    Scaffold(
        containerColor = GrayBg,

        bottomBar = {
            BottomNavigationBar(
                selectedItem = BottomNavItem.AGENDA,
                onHomeClick = {},
                onAgendaClick = {},
                onServicesClick = {},
                onProfileClick = {}
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            // MAIN CARD
            Card(
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(BorderGray),
                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = "📅",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "Turny",
                                style = MaterialTheme.typography.headlineMedium
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(BorderGray),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "AR",
                                color = PrimaryBlue,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // TITLE
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Panel de Reservas",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Gestiona las citas de tu negocio",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // CALENDAR CARD
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            // MONTH
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                                    contentDescription = null
                                )

                                Text(
                                    text = "Febrero 2026",
                                    style = MaterialTheme.typography.bodyLarge
                                )

                                Icon(
                                    imageVector = Icons.Outlined.KeyboardArrowRight,
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            // DAYS
                            CalendarWeekRow()

                            Spacer(modifier = Modifier.height(16.dp))

                            // CALENDAR NUMBERS
                            CalendarNumbers()
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    // RESERVATION CARDS
                    ReservationCard(
                        name = "Carlos Ramírez",
                        date = "Miércoles 10 de marzo",
                        time = "8:30 AM"
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    ReservationCard(
                        name = "Laura Fernandez",
                        date = "Sábado 13 de marzo",
                        time = "10:00 AM"
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun CalendarWeekRow() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        listOf("Lu", "Ma", "Mi", "Ju", "Vi", "Sa", "Do").forEach {

            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CalendarNumbers() {

    Column(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        CalendarRow(
            listOf(
                "1" to null,
                "2" to null,
                "3" to YellowAccent,
                "4" to RedHard,
                "5" to RedHard,
                "6" to null,
                "7" to null
            )
        )

        CalendarRow(
            listOf(
                "8" to null,
                "9" to null,
                "10" to FreshGreen,
                "11" to FreshGreen,
                "12" to FreshGreen,
                "13" to FreshGreen,
                "14" to null
            )
        )

        CalendarRow(
            listOf(
                "15" to null,
                "16" to FreshGreen,
                "17" to null,
                "18" to null,
                "19" to null,
                "20" to null,
                "21" to null
            )
        )

        CalendarRow(
            listOf(
                "22" to null,
                "23" to null,
                "24" to null,
                "25" to null,
                "26" to null,
                "27" to null,
                "28" to null
            )
        )
    }
}

@Composable
fun CalendarRow(
    days: List<Pair<String, androidx.compose.ui.graphics.Color?>>
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        days.forEach { (number, color) ->

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(color ?: White),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = number,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ReservationCard(
    name: String,
    date: String,
    time: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = date,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = time,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = PrimaryBlue
                    )
                ) {

                    Text(
                        text = "Editar",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = RedHard
                    )
                ) {

                    Text(
                        text = "Cancelar",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}