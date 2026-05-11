package com.app.turny.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.turny.domain.model.Role

@Composable
fun RoleSelector(
    selectedRole: Role,
    onRoleSelected: (Role) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(
            onClick = {
                onRoleSelected(Role.CLIENT)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor =
                    if (selectedRole == Role.CLIENT)
                        Color(0xFF2563EB)
                    else
                        Color.LightGray
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "Cliente",
                color = Color.White
            )
        }

        Button(
            onClick = {
                onRoleSelected(Role.BUSINESS)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor =
                    if (selectedRole == Role.BUSINESS)
                        Color(0xFF2563EB)
                    else
                        Color.LightGray
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "Negocio",
                color = Color.White
            )
        }
    }
}