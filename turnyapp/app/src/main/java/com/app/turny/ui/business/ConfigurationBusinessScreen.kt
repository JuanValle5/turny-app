package com.app.turny.ui.business

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
                userName = "Barbería El Rey",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxSize()
            ) {

                Text(
                    text = "Mi perfil",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

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

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Barbería El Rey",
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp,
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Datos del negocio",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                ProfileInfoRow(
                    label = "Nombre propietario",
                    value = "Pedro López"
                )

                Spacer(modifier = Modifier.height(18.dp))

                ProfileInfoRow(
                    label = "Nombre negocio",
                    value = "Barbería El Rey"
                )

                Spacer(modifier = Modifier.height(18.dp))

                ProfileInfoRow(
                    label = "Correo electrónico",
                    value = "barberiaelrey@gmail.com"
                )

                Spacer(modifier = Modifier.height(18.dp))

                ProfileInfoRow(
                    label = "Teléfono",
                    value = "+57 357 942 6907"
                )

                Spacer(modifier = Modifier.height(18.dp))

                ProfileInfoRow(
                    label = "Dirección",
                    value = "Cali, Colombia"
                )

                Spacer(modifier = Modifier.weight(1f))

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

                Spacer(modifier = Modifier.height(16.dp))
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