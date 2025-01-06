package org.scesi.cappuchino.ui.utils

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
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.models.SearchCategory
import org.scesi.cappuchino.ui.models.mockedSubjects


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchList: List<SearchCategory>, isSearchBarFocused: (Boolean) -> Unit) {

    var searchText by remember { mutableStateOf("") }
    val filteredCarreras = searchList.filter { carrera ->
        carrera.searchCriteria.contains(searchText, ignoreCase = true)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_padding_size_smallv1))
    ) {

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = {
            Text(
                text = stringResource(R.string.text_searchbar),
                fontSize = dimensionResource(id = R.dimen.text_size_small).value.sp
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.lupaicon),
                contentDescription = stringResource(R.string.Search),
                modifier = Modifier.size(24.dp),
                tint = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.margin_padding_size_xxxlarge))
            .padding(horizontal = dimensionResource(id = R.dimen.margin_padding_size_smallv1))
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.margin_padding_size_small)))
            .onFocusEvent { focusState ->
                if (focusState.isFocused) {
                    isSearchBarFocused(false)
                } else {
                    isSearchBarFocused(true)
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_padding_size_small))
    )
    Spacer(modifier = Modifier.height(16.dp))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        if (filteredCarreras.isEmpty()) {
            Text(
                text = stringResource(id = R.string.not_found),
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            filteredCarreras.forEach { carrera ->
                TextBoxSearch(text = carrera.searchCriteria, onClick = {
                })
            }
        }
    }
        }
}


@Composable
fun TextBoxSearch(
    text: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(dimensionResource(id = R.dimen.margin_padding_size_smallv1))
            .background(
                color = Color(0xFFD1D8FF),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_padding_size_small))
            )
            .clickable { onClick() }
            .padding(
                horizontal = dimensionResource(id = R.dimen.margin_padding_size_small),
                vertical = dimensionResource(id = R.dimen.margin_padding_size_smallv3)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = dimensionResource(id = R.dimen.text_size_small).value.sp,
            color = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.fecha),
            contentDescription = stringResource(R.string.arrow_icon),
            tint = Color.Black,
            modifier = Modifier.size(dimensionResource(id = R.dimen.margin_padding_size_medium))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    SearchBar(searchList = mockedSubjects, isSearchBarFocused = {})
}
