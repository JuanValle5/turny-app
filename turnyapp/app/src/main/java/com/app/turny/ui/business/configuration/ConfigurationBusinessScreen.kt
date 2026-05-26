package com.app.turny.ui.business.configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.BusinessBottomNavBar
import com.app.turny.ui.components.BusinessNavItem
import com.app.turny.ui.components.ProfileInfoRow
import com.app.turny.ui.components.structure.AppHeader

@Composable
fun ConfigurationBusinessScreen(

    onLogout: () -> Unit,

    onNavigateToInit: () -> Unit,

    onNavigateToAgenda: () -> Unit,

    onNavigateToServices: () -> Unit,

    viewModel: ConfigurationBusinessViewModel =
        viewModel()
) {
    val uiState by
    viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
    ) {

        // CONTENT
        Column(
            modifier = Modifier
                .weight(1f)
        ) {

            // HEADER
            AppHeader(
                userName = uiState.ownerName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),

                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {
                    Text(
                        text = "Mi perfil",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))

                }

                item {
                    // PROFILE IMAGE
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFD9E6FF))
                            .align(Alignment.CenterHorizontally),

                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(18.dp))
                }

                item {
                    Text(
                        text = uiState.businessName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally
                        )
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(32.dp))
                }

                item {
                    Text(
                        text = "Datos del negocio",
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp
                    )
                }

                item {
                    ProfileInfoRow(
                        label = "Nombre propietario",
                        value = uiState.ownerName
                    )
                }

                item {
                    ProfileInfoRow(
                        label = "Nombre negocio",
                        value = uiState.businessName
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "Correo electrónico",
                        value = uiState.email
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "Teléfono",
                        value = uiState.phone
                    )
                }

                item {
                    ProfileInfoRow(
                        label = "Dirección",
                        value =
                            "${uiState.address}, ${uiState.city}"
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "WhatsApp",
                        value = uiState.whatsapp
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "Categoría",
                        value = uiState.category
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "WhatsApp",
                        value = uiState.whatsapp
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "Sitio web",
                        value = uiState.website
                    )
                }
                item {
                    ProfileInfoRow(
                        label = "Código negocio",
                        value = uiState.businessCode
                    )
                }

                item {
                    // LOGOUT BUTTON
                    Button(
                        onClick = {

                            viewModel.logout {

                                onLogout()
                            }
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Red,
                                shape = RoundedCornerShape(14.dp)
                            ),

                        shape = RoundedCornerShape(14.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {

                        Text(
                            text = "Cerrar Sesión",
                            color = Color.Red,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    }
                }

            }
        }

        // FOOTER
        BusinessBottomNavBar(

            selectedItem = BusinessNavItem.PROFILE,

            onItemSelected = { item ->

                when(item){

                    BusinessNavItem.INIT -> {

                        onNavigateToInit()
                    }

                    BusinessNavItem.AGENDA -> {

                        onNavigateToAgenda()
                    }

                    BusinessNavItem.SERVICES -> {

                        onNavigateToServices()
                    }

                    else -> {}
                }
            }
        )
    }
}