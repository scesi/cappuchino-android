package org.scesi.cappuchino.ui.navigation

import androidx.annotation.StringRes
import org.scesi.cappuchino.R

enum class BottomNavBarItem(
    val navCommand: NavFeature,
    val iconSelected: Int,
    val iconUnselected: Int,
    @StringRes val route: Int
) {
    HOME(
        navCommand = NavFeature.Home,
        iconSelected = R.drawable.ic_home_full,
        iconUnselected = R.drawable.ic_home_empty,
        route = R.string.Inicio
    ),
    SCHEDULE(
        navCommand = NavFeature.Schedule,
        iconSelected = R.drawable.ic_horario_full,
        iconUnselected = R.drawable.ic_horario_empty,
        route = R.string.Horario
    ),
    MORE(
    navCommand = NavFeature.More,
    iconSelected = R.drawable.tacitafull,
    iconUnselected = R.drawable.tacitaempty,
    route = R.string.Más
    );
}

 val bottomNavBarItems = listOf(
     BottomNavBarItem.HOME,
     BottomNavBarItem.SCHEDULE,
     BottomNavBarItem.MORE
)