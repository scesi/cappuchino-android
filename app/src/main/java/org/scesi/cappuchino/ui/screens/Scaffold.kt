package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.navigation.BottomNavigationBar
import org.scesi.cappuchino.ui.navigation.CappuchinoTopBar

@Composable
fun CappuchinoScaffold(
    title: String = "",
    navController: NavController,
    cappuchinoState: CappuchinoState,
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = Color.Transparent,
        darkIcons = false
    )
    Scaffold(
        topBar = { CappuchinoTopBar(title) },
        bottomBar = {
            NavigationBar {
                BottomNavigationBar(
                    selectedItemIndex = cappuchinoState.selectedItemIndex,
                    onNavBarItemClicked = { bottomNavBarItem ->
                        cappuchinoState.onNavBarItemClicked(bottomNavBarItem)
                    })
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(
                        horizontal = 2.dp
                    )
            ) {
                content()
            }
        }
    )
}
