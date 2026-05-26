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
import androidx.compose.material.icons.outlined.Person
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.BottomNavItem
import com.app.turny.ui.components.BottomNavigationBar
import com.app.turny.ui.theme.BorderGray
import com.app.turny.ui.theme.GrayBg
import com.app.turny.ui.theme.PrimaryBlue
import com.app.turny.ui.theme.RedHard
import com.app.turny.ui.theme.White

@Composable
fun ConfigurationBusinessScreen(



    onLogout: () -> Unit,

    viewModel: ConfigurationBusinessViewModel =
        viewModel()
) {

    Scaffold(
        containerColor = GrayBg,

        bottomBar = {
            BottomNavigationBar(
                selectedItem = BottomNavItem.PROFILE,
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

                    Spacer(modifier = Modifier.height(16.dp))

                    // TITLE
                    Text(
                        text = "Mi perfil",
                        modifier = Modifier.padding(horizontal = 20.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // PROFILE IMAGE
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .size(128.dp)
                                .clip(CircleShape)
                                .background(BorderGray),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = null,
                                modifier = Modifier.size(82.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // BUSINESS NAME
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Barbería el Rey",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(34.dp))

                    // PERSONAL DATA
                    Column(
                        modifier = Modifier.padding(horizontal = 20.dp)
                    ) {

                        Text(
                            text = "Datos personales",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        ProfileRow(
                            title = "Nombre Propietario",
                            value = "Pedro López"
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        ProfileRow(
                            title = "Nombre negocio",
                            value = "barberiaelrey@gmail.com"
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        ProfileRow(
                            title = "Teléfono",
                            value = "+57  357 942 6907"
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // LOGOUT BUTTON
                    OutlinedButton(
                        onClick = {

                            viewModel.logout {

                                onLogout()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = RedHard
                        )
                    ) {

                        Text(
                            text = "Cerrar Sesión",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}

@Composable
fun ProfileRow(
    title: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
