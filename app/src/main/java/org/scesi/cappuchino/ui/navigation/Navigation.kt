package org.scesi.cappuchino.ui.navigation

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
        startDestination = NavFeature.Home
    ){
        home(navController = navHostController)

    }


}

private fun NavGraphBuilder.home(navController: NavController){
    composable<NavFeature.Home>{
        HomeScreen()
    }
}
