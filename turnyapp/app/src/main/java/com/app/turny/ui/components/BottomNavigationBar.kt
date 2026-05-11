package com.app.turny.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.ContentCut
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class BottomNavItem {
    HOME,
    AGENDA,
    SERVICES,
    PROFILE
}

@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavItem,
    onHomeClick: () -> Unit,
    onAgendaClick: () -> Unit,
    onServicesClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    val selectedColor = Color(0xFF3B82F6)
    val unselectedColor = Color(0xFF6B7280)

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        containerColor = Color.White
    ) {

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.HOME,
            onClick = onHomeClick,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.GridView,
                    contentDescription = "Inicio"
                )
            },
            label = { Text("Inicio") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = Color.Transparent,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.AGENDA,
            onClick = onAgendaClick,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Agenda"
                )
            },
            label = { Text("Agenda") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = Color.Transparent,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.SERVICES,
            onClick = onServicesClick,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.ContentCut,
                    contentDescription = "Servicios"
                )
            },
            label = { Text("Servicios") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = Color.Transparent,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )

        NavigationBarItem(
            selected = selectedItem == BottomNavItem.PROFILE,
            onClick = onProfileClick,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.PersonOutline,
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                selectedTextColor = selectedColor,
                indicatorColor = Color.Transparent,
                unselectedIconColor = unselectedColor,
                unselectedTextColor = unselectedColor
            )
        )
    }
}