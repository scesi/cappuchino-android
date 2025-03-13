package org.scesi.cappuchino.ui.navigation

import AboutScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.scesi.cappuchino.ui.screens.home.HomeScreen
import org.scesi.cappuchino.ui.screens.SettingsScreen


@Composable
fun CappuchinoNavigation(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = NavFeature.Home
    ){
        home(navController = navHostController)
        about(navController = navHostController)

    }


}

private fun NavGraphBuilder.home(navController: NavController){
    composable<NavFeature.Home>{
        HomeScreen()
    }
}

private fun NavGraphBuilder.settings(navController: NavController){
    composable<NavFeature.Settings>{
        SettingsScreen()
    }
}
private fun NavGraphBuilder.about(navController: NavController) {
    composable<NavFeature.About> {
        AboutScreen()
    }
}