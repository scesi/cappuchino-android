package org.scesi.cappuchino.ui.navigation

import AboutScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.scesi.cappuchino.ui.screens.ScheduleScreen
import org.scesi.cappuchino.ui.screens.home.HomeScreen
import org.scesi.cappuchino.ui.screens.SettingsScreen
import org.scesi.cappuchino.ui.screens.home.MoreScreen


@Composable
fun CappuchinoNavigation(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = NavFeature.Home
    ){
        home(navController = navHostController)
        schedule(navController = navHostController)
        more(navController = navHostController)
        about(navController = navHostController)
        settings(navController = navHostController)
    }


}

private fun NavGraphBuilder.home(navController: NavController){
    composable<NavFeature.Home>{
        HomeScreen(navController)
    }
}
private fun NavGraphBuilder.schedule(navController: NavController){
    composable<NavFeature.Schedule>{
        ScheduleScreen()
    }
}
private fun NavGraphBuilder.more(navController: NavController){
    composable<NavFeature.More>{
        MoreScreen()
    }
}
private fun NavGraphBuilder.settings(navController: NavController){
    composable<NavFeature.Settings>{
        SettingsScreen(navController)
    }
}
private fun NavGraphBuilder.about(navController: NavController) {
    composable<NavFeature.About> {
        AboutScreen()
    }
}