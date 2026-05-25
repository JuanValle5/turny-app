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
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
//import com.app.turny.components.BottomNavItem
//import com.app.turny.components.BottomNavigationBar
import com.app.turny.ui.components.BottomNavItem
import com.app.turny.ui.components.BottomNavigationBar
import com.app.turny.ui.theme.BorderGray
import com.app.turny.ui.theme.GrayBg
import com.app.turny.ui.theme.PrimaryBlue
import com.app.turny.ui.theme.PrimaryBlueHard
import com.app.turny.ui.theme.White

@Composable
fun HomeBusinessScreen(
    onNavigateToConfiguration: () -> Unit
) {

    Scaffold(
        containerColor = GrayBg,

        bottomBar = {
            BottomNavigationBar(

                selectedItem = BottomNavItem.HOME,

                onHomeClick = {},

                onAgendaClick = {},

                onServicesClick = {},

                onProfileClick = {

                    onNavigateToConfiguration()
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = PrimaryBlue,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Agregar",
                    tint = White
                )
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            // HEADER CARD
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column {

                    // TOP BAR
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
                                    .size(45.dp)
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
                                .size(40.dp)
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

                    Divider(color = BorderGray)

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        // GREETING
                        Text(
                            text = "Buen día!",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Jueves, 5 de febrero",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(22.dp))

                        // STATS
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
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

                        Spacer(modifier = Modifier.height(28.dp))

                        // CALENDAR
                        Card(
                            shape = RoundedCornerShape(22.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            )
                        ) {

                            Column(
                                modifier = Modifier.padding(18.dp)
                            ) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Text(
                                        text = "‹",
                                        style = MaterialTheme.typography.headlineMedium
                                    )

                                    Text(
                                        text = "Febrero 2026",
                                        style = MaterialTheme.typography.bodyLarge
                                    )

                                    Text(
                                        text = "›",
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                }

                                Spacer(modifier = Modifier.height(18.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {

                                    DayItem("Lun", "2", false)
                                    DayItem("Mar", "3", false)
                                    DayItem("Mié", "4", false)
                                    DayItem("Jue", "5", true)
                                    DayItem("Vie", "6", false)
                                    DayItem("Sáb", "7", false)
                                    DayItem("Dom", "8", false)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        // SECTION TITLE
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Citas – hoy",
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Text(
                                text = "5 citas",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        // APPOINTMENT CARD
                        Card(
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = White
                            )
                        ) {

                            Row(
                                modifier = Modifier.padding(14.dp)
                            ) {

                                // HOUR BOX
                                Box(
                                    modifier = Modifier
                                        .width(74.dp)
                                        .height(100.dp)
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(PrimaryBlue),
                                    contentAlignment = Alignment.Center
                                ) {

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {

                                        Text(
                                            text = "09",
                                            color = White,
                                            style = MaterialTheme.typography.headlineMedium
                                        )

                                        Text(
                                            text = ":00",
                                            color = White,
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {

                                    Text(
                                        text = "Corte de cabello",
                                        style = MaterialTheme.typography.bodyLarge
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = "Carlos Mendoza",
                                        style = MaterialTheme.typography.bodyMedium
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Icon(
                                            imageVector = Icons.Outlined.CheckCircle,
                                            contentDescription = null,
                                            modifier = Modifier.size(18.dp)
                                        )

                                        Spacer(modifier = Modifier.width(6.dp))

                                        Text(
                                            text = "30 min",
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(BorderGray)
                                            .padding(
                                                horizontal = 16.dp,
                                                vertical = 8.dp
                                            )
                                    ) {

                                        Text(
                                            text = "Confirmado",
                                            color = PrimaryBlueHard,
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    label: String
) {

    Card(
        modifier = Modifier.height(110.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 22.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun DayItem(
    day: String,
    number: String,
    selected: Boolean
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = day,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .size(
                    width = 40.dp,
                    height = 64.dp
                )
                .clip(RoundedCornerShape(30.dp))
                .background(
                    if (selected) PrimaryBlue
                    else White
                ),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = number,
                color = if (selected) White else PrimaryBlueHard,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}