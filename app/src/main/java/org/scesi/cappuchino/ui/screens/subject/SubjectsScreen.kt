package org.scesi.cappuchino.ui.screens.subject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.rememberCappuchinoState

@Composable
fun SubjectScreen(
    navController: NavController,
    cappuchinoState: CappuchinoState,
    viewModel: SubjectViewModel = koinViewModel()
) {

    val subjectText by viewModel.subjectState.collectAsState()

    SubjectScreenContent(subjectText)
}

@Composable
fun SubjectScreenContent(text: String) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun SubjectScreenPreview() {
    SubjectScreen(navController = rememberNavController(), cappuchinoState = rememberCappuchinoState())
}
