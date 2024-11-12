package org.scesi.cappuchino.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import org.scesi.cappuchino.ui.navigation.CappuchinoNavigation
import org.scesi.cappuchino.ui.theme.CappuchinoTheme

@Composable
fun Cappuchino() {
    val appState = rememberCappuchinoState()
    CappuchinoScreen {
        CappuchinoNavigation(
            navHostController = appState.navController
        )
    }
}


@Composable
fun CappuchinoScreen(content: @Composable () -> Unit) {
    CappuchinoTheme {
        Surface {
            content()
        }
    }
}