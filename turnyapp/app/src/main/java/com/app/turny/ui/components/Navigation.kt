package com.app.turny.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class CustomerNavItem {
    EXPLORE,
    APPOINTMENTS,
    FAVORITES,
    PROFILE
}

@Composable
fun CustomerBottomNavBar(
    selectedItem: CustomerNavItem,
    onItemSelected: (CustomerNavItem) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(92.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        BottomNavItem(
            title = "Explorar",
            isSelected = selectedItem == CustomerNavItem.EXPLORE,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Explorar"
                )
            },
            onClick = {
                onItemSelected(CustomerNavItem.EXPLORE)
            }
        )

        BottomNavItem(
            title = "Mis citas",
            isSelected = selectedItem == CustomerNavItem.APPOINTMENTS,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Mis citas"
                )
            },
            onClick = {
                onItemSelected(CustomerNavItem.APPOINTMENTS)
            }
        )

        BottomNavItem(
            title = "Favoritos",
            isSelected = selectedItem == CustomerNavItem.FAVORITES,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favoritos"
                )
            },
            onClick = {
                onItemSelected(CustomerNavItem.FAVORITES)
            }
        )

        BottomNavItem(
            title = "Perfil",
            isSelected = selectedItem == CustomerNavItem.PROFILE,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.PersonOutline,
                    contentDescription = "Perfil"
                )
            },
            onClick = {
                onItemSelected(CustomerNavItem.PROFILE)
            }
        )
    }
}

@Composable
private fun BottomNavItem(
    title: String,
    isSelected: Boolean,
    icon: @Composable () -> Unit,
    onClick: () -> Unit
) {

    /*androidx.compose.foundation.clickable(
        onClick = onClick
    ) {
    }*/

    androidx.compose.foundation.layout.Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val activeColor = MaterialTheme.colorScheme.primary
        val inactiveColor = MaterialTheme.colorScheme.tertiary

        val currentColor =
            if (isSelected) activeColor else inactiveColor

        androidx.compose.foundation.layout.Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            androidx.compose.material3.IconButton(
                onClick = onClick
            ) {
                androidx.compose.material3.Icon(
                    tint = currentColor,
                    contentDescription = title,
                    imageVector = when (title) {
                        "Explorar" -> Icons.Outlined.Search
                        "Mis citas" -> Icons.Outlined.CalendarMonth
                        "Favoritos" -> Icons.Outlined.FavoriteBorder
                        else -> Icons.Outlined.PersonOutline
                    }
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = currentColor
            )

            if (isSelected) {
                androidx.compose.foundation.layout.Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .height(3.dp)
                        .fillMaxWidth(0.5f)
                        .clip(RoundedCornerShape(50))
                        .background(activeColor)
                )
            }
        }
    }
}