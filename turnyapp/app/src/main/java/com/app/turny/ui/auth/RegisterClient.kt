package com.app.turny.ui.auth

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.ui.components.RoleSelector

private val PrimaryBlue = Color(0xFF3B82F6)
private val BackgroundColor = Color(0xFFF3F4F6)
private val GrayText = Color(0xFF9CA3AF)
private val BorderColor = Color(0xFFE5E7EB)

@Composable
fun RegisterClientScreen(
    viewModel: RegisterViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {

            // BOTÓN VOLVER
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .border(
                        width = 1.dp,
                        color = BorderColor,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                IconButton(
                    onClick = { }
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Volver"
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // TÍTULO
            Text(
                text = "Crear cuenta",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Datos personales",
                fontSize = 14.sp,
                color = GrayText,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // SELECTOR CLIENTE / NEGOCIO
            RoleSelector(
                selectedRole = uiState.selectedRole,
                onRoleSelected = {
                    viewModel.onRoleChange(it)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // NOMBRE
            Text(
                text = "Nombre Completo",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            CustomField(
                value = uiState.fullName,

                onValueChange = {
                    viewModel.onFullNameChange(it)
                },

                placeholder = "Tu nombre",

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        tint = GrayText
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // CORREO
            Text(
                text = "Correo electrónico",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            CustomField(
                value = uiState.email,

                onValueChange = {
                    viewModel.onEmailChange(it)
                },

                placeholder = "tu@correo.com",

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = null,
                        tint = GrayText
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // TELÉFONO
            Text(
                text = "Teléfono",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            CustomField(
                value = uiState.phone,

                onValueChange = {
                    viewModel.onPhoneChange(it)
                },

                placeholder = "312 456 2523",

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = null,
                        tint = GrayText
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // CONTRASEÑA
            Text(
                text = "Contraseña",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = uiState.password,

                onValueChange = {
                    viewModel.onPasswordChange(it)
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(14.dp),

                placeholder = {
                    Text(
                        text = "Mínimo 8 caracteres",
                        color = GrayText
                    )
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = null,
                        tint = GrayText
                    )
                },

                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = BorderColor,
                    unfocusedBorderColor = BorderColor,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ERROR
            uiState.error?.let {

                Text(
                    text = it,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            // LOADING
            if (uiState.isLoading) {

                CircularProgressIndicator()

                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            // BOTÓN REGISTRO
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PrimaryBlue,
                        shape = RoundedCornerShape(14.dp)
                    )
                    .clickable {
                        viewModel.register()
                    }
                    .padding(vertical = 16.dp),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Crear mi cuenta",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // FOOTER
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "¿Ya tienes cuenta? ",
                    color = GrayText,
                    fontSize = 14.sp
                )

                Text(
                    text = "Inicia sesión",
                    color = PrimaryBlue,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun CustomField(

    value: String,

    onValueChange: (String) -> Unit,

    placeholder: String,

    leadingIcon: @Composable () -> Unit
) {

    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(14.dp),

        placeholder = {
            Text(
                text = placeholder,
                color = GrayText
            )
        },

        leadingIcon = leadingIcon,

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BorderColor,
            unfocusedBorderColor = BorderColor,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}