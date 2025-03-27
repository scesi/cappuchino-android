package org.scesi.cappuchino.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(
    bottomNavOptions: List<BottomNavBarItem> = bottomNavBarItems,
    onNavBarItemClicked : (BottomNavBarItem) -> Unit,
    navController: NavController

) {


    NavigationBar {
        val currentRoute = bottomNavOptions.first().navCommand
        bottomNavOptions.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.rute) },
                label = { Text(screen.rute) },
                selected = currentRoute == screen.navCommand,
                onClick = {
                    onNavBarItemClicked(screen)
                }
            )
        }
    }
}
