package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.scesi.cappuchino.R
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.scesi.cappuchino.ui.theme.CappuchinoTheme
import org.scesi.cappuchino.ui.utils.SearchBar
import org.scesi.cappuchino.ui.utils.SearchCategory


@Composable
fun HomeScreen() {
    val title = stringResource(id = R.string.titulo_main)
    CappuchinoScaffold(title) {
        HomeScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CappuchinoTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_padding_size_mediumv2)),
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
        val subjects = listOf(
            SearchCategory.Subject("Licenciatura en Ing en Sistemas"),
            SearchCategory.Subject("Licenciatura en Ing en Informática"),
            SearchCategory.Subject("Matematica"),
            SearchCategory.Subject("Fisica")
        )
        SearchBar(subjects)

    }
}


