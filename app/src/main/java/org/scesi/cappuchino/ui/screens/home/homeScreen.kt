package org.scesi.cappuchino.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.rememberCappuchinoState
import org.scesi.cappuchino.ui.theme.CappuchinoTheme
import org.scesi.cappuchino.ui.utils.SearchBar
import org.scesi.domain.models.SearchCategory


@Composable
fun HomeScreen(
    goToCareers: (code: String, path: String ) -> Unit,
    navController: NavController,
    cappuchinoState: CappuchinoState,
    viewModel: HomeViewModel = koinViewModel()
) {
    val title = stringResource(id = R.string.titulo_main)
    var searchBarVisible by remember { mutableStateOf(true) }
    val careerList = viewModel.dataState.collectAsState().value.careers
    HomeScreenContent(
        goToCareers = goToCareers,
        searchBarVisible = searchBarVisible,
        onSearchBarFocusChanged = { isVisible -> searchBarVisible = isVisible },
        searchList = careerList
    )

}

@Composable
fun HomeScreenContent(
    goToCareers: (code: String, path: String ) -> Unit,
    searchBarVisible: Boolean,
    onSearchBarFocusChanged: (Boolean) -> Unit,
    searchList: List<SearchCategory.Career>
) {
    val density = LocalDensity.current
    val slideOffset = with(density) { -40.dp.roundToPx() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_padding_size_mediumv2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AnimatedVisibility(
            visible = searchBarVisible,
            enter = slideInVertically { slideOffset } + expandVertically(expandFrom = Alignment.Top) + fadeIn(),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = stringResource(R.string.title_home),
                    textAlign = TextAlign.Center,
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(top = dimensionResource(id = R.dimen.margin_padding_size_mediumv2))
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_small)))

                Image(
                    painter = painterResource(id = R.drawable.cap),
                    contentDescription = stringResource(R.string.taza_logo),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.margin_padding_size_xxlarge))
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))
            }
        }

        SearchBar(
            searchList = searchList,
            isSearchBarFocused = { isFocused -> onSearchBarFocusChanged(isFocused) },
            onCareerClick = { careerId, path -> goToCareers(careerId, path) }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CappuchinoTheme {
        HomeScreen(
            goToCareers = {code, path ->  } , navController = rememberNavController(), cappuchinoState = rememberCappuchinoState()
        )
    }
}