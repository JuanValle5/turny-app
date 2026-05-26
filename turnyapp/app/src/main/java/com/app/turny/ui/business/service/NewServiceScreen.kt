package com.app.turny.ui.business.service

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ContentCut
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.app.turny.ui.components.BusinessBottomNavBar
import com.app.turny.ui.components.BusinessNavItem
import com.app.turny.ui.components.structure.AppHeader
import com.app.turny.ui.theme.PrimaryBlue
import com.app.turny.ui.theme.White

@Composable
fun NewServiceScreen(
//    onNavigateToInit: () -> Unit,
//    onNavigateToAgenda: () -> Unit,
//    onNavigateToProfile: () -> Unit,
//    onBack: () -> Unit
) {

    val serviceName = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val price = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F8FA))
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            AppHeader(
                userName = "BR",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                item {

                    // TITLE
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.Top
                    ) {

                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .clip(RoundedCornerShape(14.dp))
                                .background(Color(0xFFEFF2F5))
                                .size(42.dp)
                        ) {

                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = null
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {

                            Text(
                                text = "Nuevo Servicio",
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Agrega un servicio a tu catalogo",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // PREVIEW CARD
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFEAF7FB)
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            Color(0xFFBFE3F3)
                        )
                    ) {

                        Row(
                            modifier = Modifier.padding(18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Color(0xFFD8EDF7)),
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Outlined.ContentCut,
                                    contentDescription = null,
                                    tint = PrimaryBlue,
                                    modifier = Modifier.size(28.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = serviceName.value.ifEmpty { "Nombre del servicio" },
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        imageVector = Icons.Outlined.AccessTime,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp),
                                        tint = Color.Gray
                                    )

                                    Spacer(modifier = Modifier.width(4.dp))

                                    Text(
                                        text = "-- min",
                                        color = Color.Gray
                                    )

                                    Spacer(modifier = Modifier.width(18.dp))

                                    Text(
                                        text = "$ 0.00",
                                        color = Color(0xFF00B86B)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    // NAME
                    FormLabel("Nombre del servicio", true)

                    CustomTextField(
                        value = serviceName.value,
                        onValueChange = {
                            serviceName.value = it
                        },
                        placeholder = "Ej: Corte clasico, Manicure gel..."
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // CATEGORY
                    FormLabel("Categoria", false)

                    DropdownField(
                        text = "Selecciona una categoria"
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // DURATION + PRICE
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            FormLabel("Duracion", true)

                            DropdownField(
                                text = "Duracion",
                                icon = Icons.Outlined.AccessTime
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            FormLabel("Precio", true)

                            OutlinedTextField(
                                value = price.value,
                                onValueChange = {
                                    price.value = it
                                },
                                leadingIcon = {
                                    Text("$")
                                },
                                placeholder = {
                                    Text("0.00")
                                },
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                modifier = Modifier.fillMaxWidth(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color(0xFFD8DCE3),
                                    unfocusedBorderColor = Color(0xFFD8DCE3),
                                    focusedContainerColor = White,
                                    unfocusedContainerColor = White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    // DESCRIPTION
                    FormLabel("Descripcion", false, "(opcional)")

                    OutlinedTextField(
                        value = description.value,
                        onValueChange = {
                            if (it.length <= 200) {
                                description.value = it
                            }
                        },
                        placeholder = {
                            Text("Describe brevemente el servicio...")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Description,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFD8DCE3),
                            unfocusedBorderColor = Color(0xFFD8DCE3),
                            focusedContainerColor = White,
                            unfocusedContainerColor = White
                        )
                    )

                    Text(
                        text = "${description.value.length}/200",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp, top = 6.dp),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    // BUTTON
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .height(56.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7EC4F0)
                        )
                    ) {

                        Text(
                            text = "Guardar Servicio",
                            color = White,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }

        // FOOTER
        BusinessBottomNavBar(
            selectedItem = BusinessNavItem.SERVICES,
            onItemSelected = { item ->

                when(item){

                    BusinessNavItem.INIT -> {
                        //onNavigateToInit()
                    }

                    BusinessNavItem.AGENDA -> {
                        //onNavigateToAgenda()
                    }

                    BusinessNavItem.PROFILE -> {
                        //onNavigateToProfile()
                    }

                    else -> {}
                }
            }
        )
    }
}

@Composable
fun FormLabel(
    title: String,
    required: Boolean,
    optionalText: String = ""
) {

    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )

        if (required) {

            Text(
                text = " *",
                color = Color.Red
            )
        }

        if (optionalText.isNotEmpty()) {

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = optionalText,
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {

            Icon(
                imageVector = Icons.Outlined.ContentCut,
                contentDescription = null
            )
        },
        placeholder = {
            Text(placeholder)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFD8DCE3),
            unfocusedBorderColor = Color(0xFFD8DCE3),
            focusedContainerColor = White,
            unfocusedContainerColor = White
        )
    )
}

@Composable
fun DropdownField(
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Outlined.LocalOffer
) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .border(
                width = 1.dp,
                color = Color(0xFFD8DCE3),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 14.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(18.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            color = Color.Gray,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}