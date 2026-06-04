package com.app.turny.ui.client.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.app.turny.ui.components.business.BusinessCard
import com.app.turny.ui.components.structure.CustomerBottomNavBar
import com.app.turny.ui.components.structure.CustomerNavItem
import com.app.turny.ui.components.structure.AppHeader
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
@Composable
fun HomeClientScreen(

    onNavigateToProfile: () -> Unit,

    onNavigateToAppointments: () -> Unit,

    onNavigateToFavorites: () -> Unit,

    onNavigateToBusiness: (String) -> Unit,

    viewModel: HomeClientViewModel = viewModel()

) {

    val uiState by viewModel.uiState.collectAsState()

    val searchedBusinessId by
    viewModel.searchedBusinessId
        .collectAsState()

    var showCodeDialog by remember {

        mutableStateOf(false)
    }

    var businessCode by remember {

        mutableStateOf("")
    }

    val context =
        LocalContext.current

    LaunchedEffect(
        searchedBusinessId
    ) {

        searchedBusinessId?.let {

            if(it == "ERROR"){

                Toast.makeText(

                    context,

                    "Negocio no encontrado",

                    Toast.LENGTH_SHORT

                ).show()

            } else {

                onNavigateToBusiness(it)
            }
            viewModel.clearSearchResult()
        }
    }

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


            AppHeader(
                userName = uiState.userName,
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

                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {

                    HorizontalDivider(
                        color = Color(0xFFE5E5E5)
                    )
                }

                item {

                    ExploreSection(

                        onCodeClick = {

                            showCodeDialog = true
                        }
                    )
                }

                item {

                    SearchSection()
                }

                item {

                    CategoriesSection()
                }

                item {

                    Text(
                        text = "${uiState.businesses.size} negocios encontrados",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }

                items(uiState.businesses) { negocio ->

                    BusinessCard(
                        negocio = negocio,
                        onClick = {

                            onNavigateToBusiness(
                                negocio.negocioId
                            )
                        }
                    )
                }

                item {

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        // FOOTER
        CustomerBottomNavBar(

            selectedItem = CustomerNavItem.EXPLORE,

            onItemSelected = { item ->

                when(item){

                    CustomerNavItem.APPOINTMENTS -> {

                        onNavigateToAppointments()
                    }

                    CustomerNavItem.FAVORITES -> {

                        onNavigateToFavorites()
                    }

                    CustomerNavItem.PROFILE -> {

                        onNavigateToProfile()
                    }

                    else -> {}
                }
            }
        )
    }
    if(showCodeDialog){

        AlertDialog(

            onDismissRequest = {

                showCodeDialog = false
            },

            title = {

                Text(
                    text = "Ingresar código"
                )
            },

            text = {

                Column {

                    Text(
                        text =
                            "Ingresa el código que te compartió el negocio"
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    OutlinedTextField(

                        value = businessCode,

                        onValueChange = {

                            businessCode = it
                        },

                        modifier =
                            Modifier.fillMaxWidth(),

                        placeholder = {

                            Text("EJ: BARBER123")
                        }
                    )
                }
            },

            confirmButton = {

                Button(

                    onClick = {

                        viewModel.searchBusinessByCode(
                            businessCode
                        )

                        showCodeDialog = false
                    }
                ) {

                    Text(
                        text = "Buscar negocio"
                    )
                }
            },
            dismissButton = {

                TextButton(

                    onClick = {

                        showCodeDialog = false
                    }
                ) {

                    Text("Cancelar")
                }
            }


        )
    }
}

@Composable
fun ExploreSection(
    onCodeClick: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {

            Text(
                text = "Explorar",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Encuentra tu servicio ideal",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        TextButton(

            onClick = onCodeClick,

            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E5E5),
                    shape = RoundedCornerShape(14.dp)
                )
        ) {

            Text(
                text = "📷 Código"
            )
        }
    }
}

@Composable
fun SearchSection() {

    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text("Buscar negocios, servicios...")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFE5E5E5),
            unfocusedBorderColor = Color(0xFFE5E5E5),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}

@Composable
fun CategoriesSection() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        CategoryChip(
            text = "Todos",
            selected = true
        )

        CategoryChip(
            text = "Barberías",
            selected = false
        )

        CategoryChip(
            text = "Peluquerías",
            selected = false
        )
    }
}

@Composable
fun CategoryChip(
    text: String,
    selected: Boolean
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) Color(0xFF3B82F6)
                else Color(0xFFE9EDF5)
            )
            .clickable { }
            .padding(horizontal = 18.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            color = if (selected) Color.White else Color.DarkGray
        )
    }
}