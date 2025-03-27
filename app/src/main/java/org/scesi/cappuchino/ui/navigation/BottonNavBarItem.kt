package org.scesi.cappuchino.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavBarItem(
    val navCommand: NavFeature,
    val icon: ImageVector,
    val rute: String
) {
    home(navCommand = NavFeature.Home, icon = Icons.Filled.Home, rute = "Inicio"),
    schedule(navCommand = NavFeature.Schedule, icon = Icons.Filled.AccountBox, rute = "Horario"),
    more(navCommand = NavFeature.More, icon = Icons.Filled.Settings, rute = "Configuraciones"),
}

 val bottomNavBarItems = listOf(
     BottomNavBarItem.home,
     BottomNavBarItem.schedule,
     BottomNavBarItem.more
)