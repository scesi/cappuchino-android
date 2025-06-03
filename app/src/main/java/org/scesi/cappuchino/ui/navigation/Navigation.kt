package org.scesi.cappuchino.ui.navigation

import AboutScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.screens.home.HomeScreen
import org.scesi.cappuchino.ui.screens.SettingsScreen
import org.scesi.cappuchino.ui.screens.MoreScreen
import org.scesi.cappuchino.ui.screens.ScheduleScreen
import org.scesi.cappuchino.ui.screens.subject.SubjectScreen


@Composable
fun CappuchinoNavigation(
    cappuchinoState: CappuchinoState,
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = NavFeature.Home
    ){
        home(navController = navHostController, cappuchinoState)
        schedule(navController = navHostController, cappuchinoState)
        more(navController = navHostController, cappuchinoState)
        about(navController = navHostController)
        settings(navController = navHostController,cappuchinoState)
        subjects(navController = navHostController, cappuchinoState)
    }


}

private fun NavGraphBuilder.home(
    navController: NavController, cappuchinoState: CappuchinoState,
) {
    composable<NavFeature.Home> {
        HomeScreen(
            goToCareers = { code, path ->
                val destination = NavFeature.Subjects(code, path)
                navController.navigate(destination)
            },
            navController = navController,
            cappuchinoState = cappuchinoState
        )
    }
}
private fun NavGraphBuilder.subjects(
    navController: NavController,
    cappuchinoState: CappuchinoState,
) {
    composable<NavFeature.Subjects> {
        SubjectScreen(
            navController, cappuchinoState
        )
    }
}

private fun NavGraphBuilder.schedule(navController: NavController, cappuchinoState: CappuchinoState,){
    composable<NavFeature.Schedule>{
        ScheduleScreen(navController, cappuchinoState)
    }
}
private fun NavGraphBuilder.more(navController: NavController, cappuchinoState: CappuchinoState){
    composable<NavFeature.More>{
        MoreScreen(navController, cappuchinoState)
    }
}
private fun NavGraphBuilder.settings(navController: NavController,cappuchinoState: CappuchinoState){
    composable<NavFeature.Settings>{
        SettingsScreen(navController, cappuchinoState)
    }
}
private fun NavGraphBuilder.about(navController: NavController) {
    composable<NavFeature.About> {
        AboutScreen()
    }
}