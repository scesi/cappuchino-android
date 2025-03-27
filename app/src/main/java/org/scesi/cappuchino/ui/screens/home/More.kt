package org.scesi.cappuchino.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.rememberCappuchinoState
import org.scesi.cappuchino.ui.screens.CappuchinoScaffold

@Composable
fun MoreScreen(
    navController: NavController,
    cappuchinoState: CappuchinoState
) {
    val title = stringResource(id = R.string.titulo_main)

    CappuchinoScaffold(title, navController, cappuchinoState) {
        MoreScreenContent()
    }
}

@Composable
fun MoreScreenContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("More Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview() {
    MoreScreen(navController = rememberNavController(), cappuchinoState = rememberCappuchinoState())
}
