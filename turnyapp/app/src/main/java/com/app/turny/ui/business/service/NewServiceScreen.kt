package com.app.turny.ui.business.service

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NewServiceScreen(

    onServiceCreated: () -> Unit,

    onBack: () -> Unit,

    viewModel: NewServiceViewModel =
        viewModel()
) {

    val uiState by
    viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.success) {

        if(uiState.success){

            onServiceCreated()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {

            // TOP BAR
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 18.dp
                    ),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(14.dp)
                        )
                        .clickable {

                            onBack()
                        },

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector =
                            Icons.Outlined.ArrowBack,

                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Nuevo Servicio",

                    style = MaterialTheme
                        .typography
                        .titleLarge,

                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.weight(1f)
                )
            }

            // CONTENT
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

                Card(
                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(24.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {

                        Text(
                            text = "Información básica",

                            fontWeight = FontWeight.Bold,

                            style = MaterialTheme
                                .typography
                                .titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(20.dp)
                        )

                        // NOMBRE
                        Text(
                            text = "Nombre del servicio"
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        OutlinedTextField(

                            value = uiState.name,

                            onValueChange = {

                                viewModel.onNameChange(it)
                            },

                            modifier = Modifier.fillMaxWidth(),

                            placeholder = {

                                Text(
                                    "Ej: Corte clásico"
                                )
                            },

                            shape = RoundedCornerShape(16.dp),

                            colors =
                                OutlinedTextFieldDefaults.colors(

                                    focusedBorderColor =
                                        Color(0xFFE5E7EB),

                                    unfocusedBorderColor =
                                        Color(0xFFE5E7EB),

                                    focusedContainerColor =
                                        Color.White,

                                    unfocusedContainerColor =
                                        Color.White
                                )
                        )

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        // DESCRIPCIÓN
                        Text(
                            text = "Descripción"
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        OutlinedTextField(

                            value = uiState.description,

                            onValueChange = {

                                viewModel.onDescriptionChange(it)
                            },

                            modifier = Modifier.fillMaxWidth(),

                            placeholder = {

                                Text(
                                    "Describe el servicio"
                                )
                            },

                            minLines = 4,

                            shape = RoundedCornerShape(16.dp),

                            colors =
                                OutlinedTextFieldDefaults.colors(

                                    focusedBorderColor =
                                        Color(0xFFE5E7EB),

                                    unfocusedBorderColor =
                                        Color(0xFFE5E7EB),

                                    focusedContainerColor =
                                        Color.White,

                                    unfocusedContainerColor =
                                        Color.White
                                )
                        )

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        Row(
                            horizontalArrangement =
                                Arrangement.spacedBy(12.dp)
                        ) {

                            // DURACIÓN
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Duración"
                                )

                                Spacer(
                                    modifier = Modifier.height(8.dp)
                                )

                                OutlinedTextField(

                                    value = uiState.duration,

                                    onValueChange = {

                                        viewModel
                                            .onDurationChange(it)
                                    },

                                    modifier =
                                        Modifier.fillMaxWidth(),

                                    placeholder = {

                                        Text("45")
                                    },

                                    shape =
                                        RoundedCornerShape(16.dp),

                                    colors =
                                        OutlinedTextFieldDefaults.colors(

                                            focusedBorderColor =
                                                Color(0xFFE5E7EB),

                                            unfocusedBorderColor =
                                                Color(0xFFE5E7EB),

                                            focusedContainerColor =
                                                Color.White,

                                            unfocusedContainerColor =
                                                Color.White
                                        )
                                )
                            }

                            // PRECIO
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Precio"
                                )

                                Spacer(
                                    modifier = Modifier.height(8.dp)
                                )

                                OutlinedTextField(

                                    value = uiState.price,

                                    onValueChange = {

                                        viewModel
                                            .onPriceChange(it)
                                    },

                                    modifier =
                                        Modifier.fillMaxWidth(),

                                    placeholder = {

                                        Text("25000")
                                    },

                                    shape =
                                        RoundedCornerShape(16.dp),

                                    colors =
                                        OutlinedTextFieldDefaults.colors(

                                            focusedBorderColor =
                                                Color(0xFFE5E7EB),

                                            unfocusedBorderColor =
                                                Color(0xFFE5E7EB),

                                            focusedContainerColor =
                                                Color.White,

                                            unfocusedContainerColor =
                                                Color.White
                                        )
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        // CATEGORÍA
                        Text(
                            text = "Categoría"
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        OutlinedTextField(

                            value = uiState.category,

                            onValueChange = {

                                viewModel
                                    .onCategoryChange(it)
                            },

                            modifier = Modifier.fillMaxWidth(),

                            placeholder = {

                                Text(
                                    "Ej: Barbería"
                                )
                            },

                            shape = RoundedCornerShape(16.dp),

                            colors =
                                OutlinedTextFieldDefaults.colors(

                                    focusedBorderColor =
                                        Color(0xFFE5E7EB),

                                    unfocusedBorderColor =
                                        Color(0xFFE5E7EB),

                                    focusedContainerColor =
                                        Color.White,

                                    unfocusedContainerColor =
                                        Color.White
                                )
                        )

                        Spacer(
                            modifier = Modifier.height(24.dp)
                        )

                        HorizontalDivider()

                        Spacer(
                            modifier = Modifier.height(24.dp)
                        )

                        // IMAGE PLACEHOLDER
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .background(
                                    color = Color(0xFFF8FAFC),
                                    shape = RoundedCornerShape(18.dp)
                                ),

                            contentAlignment = Alignment.Center
                        ) {

                            Column(
                                horizontalAlignment =
                                    Alignment.CenterHorizontally
                            ) {

                                Icon(
                                    imageVector =
                                        Icons.Outlined.Image,

                                    contentDescription = null,

                                    tint = Color.Gray,

                                    modifier = Modifier.size(48.dp)
                                )

                                Spacer(
                                    modifier = Modifier.height(10.dp)
                                )

                                Text(
                                    text = "Agregar imagen",

                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )
            }
        }

        // BOTTOM BUTTON
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp)
        ) {

            Button(

                onClick = {

                    viewModel.createService()
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),

                shape = RoundedCornerShape(18.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2563EB)
                )
            ) {

                Text(
                    text =
                        if(uiState.isLoading)
                            "Guardando..."
                        else
                            "Guardar servicio",

                    style = MaterialTheme
                        .typography
                        .titleMedium
                )
            }
        }
    }
}