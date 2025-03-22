package org.scesi.cappuchino.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavFeature.Home,
        NavFeature.Schedule,
        NavFeature.More,
    )

    val screenIcons = mapOf(
        NavFeature.Home to Icons.Filled.Home,
        NavFeature.Schedule to Icons.Filled.AccountBox,
        NavFeature.More to Icons.Filled.Settings,
    )

    val screenLabels = mapOf(
        NavFeature.Home to "Inicio",
        NavFeature.Schedule to "Horario",
        NavFeature.More to "Mas",
    )

    NavigationBar {
        val currentRoute = navController.currentDestination?.route
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screenIcons[screen] ?: Icons.Filled.Home, contentDescription = screenLabels[screen]) },
                label = { Text(screenLabels[screen] ?: "Pantalla") },
                selected = currentRoute == screen.toString(),
                onClick = {
                    if (currentRoute != screen.toString()) {
                        navController.navigate(screen)
                    }
                }
            )
        }
    }
}
