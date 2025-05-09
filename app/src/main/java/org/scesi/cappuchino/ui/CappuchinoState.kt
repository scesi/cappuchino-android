package org.scesi.cappuchino.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import org.scesi.cappuchino.ui.navigation.BottomNavBarItem
import org.scesi.cappuchino.ui.navigation.bottomNavBarItems

@Composable
fun rememberCappuchinoState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): CappuchinoState = remember(navController, coroutineScope){
    CappuchinoState(navController, coroutineScope)
}

class CappuchinoState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
) {
    var selectedItemIndex by mutableIntStateOf(0)
        private set

    fun onNavBarItemClicked(navBarItem: BottomNavBarItem) {
        selectedItemIndex = bottomNavBarItems.indexOf(navBarItem)
        navController.navigate(navBarItem.navCommand) {
            popUpTo(navController.graph.startDestinationId) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
}