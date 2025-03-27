package org.scesi.cappuchino.ui.screens

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

@Composable
fun ScheduleScreen(
    navController: NavController,
    cappuchinoState: CappuchinoState
) {
    val title = stringResource(id = R.string.titulo_main)

    CappuchinoScaffold(title, navController, cappuchinoState) {
        ScheduleScreenContent()
    }
}

@Composable
fun ScheduleScreenContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("echedule Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview() {
    ScheduleScreen(navController = rememberNavController(), cappuchinoState = rememberCappuchinoState())
}
