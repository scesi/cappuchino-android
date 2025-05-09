package org.scesi.cappuchino.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.navigation.CappuchinoNavigation
import org.scesi.cappuchino.ui.screens.CappuchinoScaffold
import org.scesi.cappuchino.ui.theme.CappuchinoTheme

@Composable
fun Cappuchino() {
    val appState = rememberCappuchinoState()
    CappuchinoScreen {
        CappuchinoScaffold(
            title = stringResource(R.string.app_name),
            navController = appState.navController,
            cappuchinoState = appState
        ) {
            CappuchinoNavigation(
                cappuchinoState = appState,
                navHostController = appState.navController
            )
        }
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