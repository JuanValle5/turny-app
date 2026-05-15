package com.app.turny.ui.business

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.outlined.ContentCut
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.app.turny.ui.theme.White

@Composable
fun ServicesBusinessScreen() {

    Scaffold(
        containerColor = GrayBg,

        bottomBar = {
            BottomNavigationBar(
                selectedItem = BottomNavItem.SERVICES,
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
                modifier = Modifier.fillMaxSize(),
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

                    Spacer(modifier = Modifier.height(12.dp))

                    // TITLE + BUTTON
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column {

                            Text(
                                text = "Servicios",
                                style = MaterialTheme.typography.headlineMedium
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Gestiona los servicios de tu negocio",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryBlue
                            ),
                            contentPadding = PaddingValues(
                                horizontal = 14.dp,
                                vertical = 8.dp
                            )
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.Add,
                                contentDescription = null,
                                tint = White,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "Nuevo",
                                color = White,
                                style = MaterialTheme.typography.bodySmall
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    // SERVICE CARD
                    ServiceCard(
                        serviceName = "Corte de cabello",
                        duration = "60 min",
                        price = "$ 15"
                    )
                }
            }
        }
    }
}

@Composable
fun ServiceCard(
    serviceName: String,
    duration: String,
    price: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ICON BOX
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(BorderGray),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Outlined.ContentCut,
                    contentDescription = null,
                    tint = PrimaryBlue
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {

                Text(
                    text = serviceName,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Outlined.AccessTime,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = duration,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.width(18.dp))

                    Text(
                        text = price,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}