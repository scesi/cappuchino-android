package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.navigation.BottomNavigationBar
import org.scesi.cappuchino.ui.navigation.CappuchinoTopBar
import org.scesi.cappuchino.ui.theme.ContainerColor
import org.scesi.cappuchino.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CappuchinoScaffold(
    title: String = "",
    navController: NavController,
    cappuchinoState: CappuchinoState,
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val isSubjectScreen = currentRoute?.contains("subjects") == true

    val topBarContent: @Composable () -> Unit = {
        if (isSubjectScreen) {
            TopAppBar(
                title = { Text("Materias") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.fecha),
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        } else {
            CappuchinoTopBar(title)
        }
    }


    systemUiController.setStatusBarColor(
        color = Color.Transparent,
        darkIcons = false
    )
    Scaffold(
        topBar = topBarContent,
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
