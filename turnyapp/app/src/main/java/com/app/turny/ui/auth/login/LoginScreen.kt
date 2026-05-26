package com.app.turny.ui.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.turny.R
import com.app.turny.ui.components.input.EmailField
import com.app.turny.ui.components.input.PasswordField
import com.app.turny.ui.components.boton.PrimaryButton
import com.app.turny.ui.components.RoleSelector

@Composable
fun LoginScreen(

    onNavigateToRegister: () -> Unit,

    onClientLoginSuccess: () -> Unit,

    onBusinessLoginSuccess: () -> Unit,

    viewModel: LoginViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.success) {

        if(uiState.success){

            if(uiState.userType == "client"){

                onClientLoginSuccess()
            }

            if(uiState.userType == "business"){

                onBusinessLoginSuccess()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
            .verticalScroll(rememberScrollState())
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.height(120.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Turny",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Gestiona tus citas fácilmente",
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(28.dp))

                // SELECTOR DE ROL
                RoleSelector(
                    selectedRole = uiState.selectedRole,
                    onRoleSelected = {
                        viewModel.onRoleChange(it)
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // EMAIL
                EmailField(
                    value = uiState.email,
                    onValueChange = {
                        viewModel.onEmailChange(it)
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // PASSWORD
                PasswordField(
                    value = uiState.password,
                    onValueChange = {
                        viewModel.onPasswordChange(it)
                    }
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

                // BOTÓN LOGIN
                PrimaryButton(
                    text = "Iniciar Sesión",
                    onClick = {
                        viewModel.login()
                    }
                )

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "¿No tienes cuenta? ",
                        color = Color.Gray
                    )

                    Text(
                        text = "Regístrate aquí",
                        color = Color(0xFF2563EB),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable {

                            onNavigateToRegister()
                        }
                    )
                }
            }
        }
    }
}