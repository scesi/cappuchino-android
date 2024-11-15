package org.scesi.cappuchino.ui.navigation

import AboutScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.scesi.cappuchino.ui.screens.HomeScreen

@Composable
fun CappuchinoNavigation(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = NavFeature.About
    ){
        home(navController = navHostController)
        about(navController = navHostController)

    }


}

private fun NavGraphBuilder.home(navController: NavController){
    composable<NavFeature.Home>{
        HomeScreen("hola")
    }
}
private fun NavGraphBuilder.about(navController: NavController) {
    composable<NavFeature.About> {
        AboutScreen()
    }
}