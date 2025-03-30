package org.scesi.cappuchino.ui.navigation

import org.scesi.cappuchino.R

enum class BottomNavBarItem(
    val navCommand: NavFeature,
    val iconSelected: Int,
    val iconUnselected: Int,
    val route: String
) {
    home(
        navCommand = NavFeature.Home,
        iconSelected = R.drawable.ic_home_full,
        iconUnselected = R.drawable.ic_home_empty,
        route = "Inicio"
    ),
    schedule(
        navCommand = NavFeature.Schedule,
        iconSelected = R.drawable.ic_horario_full,
        iconUnselected = R.drawable.ic_horario_empty,
        route = "Horario"
    ),
    more(
    navCommand = NavFeature.More,
    iconSelected = R.drawable.tacitafull,
    iconUnselected = R.drawable.tacitaempty,
    route = "Más"
    )
}

 val bottomNavBarItems = listOf(
     BottomNavBarItem.home,
     BottomNavBarItem.schedule,
     BottomNavBarItem.more
)