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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.scesi.cappuchino.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = stringResource(R.string.titulo_home),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 20.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.cap),
            contentDescription = stringResource(R.string.taza_logo),
            modifier = Modifier
                .size(40.dp)
        )
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        TextBoxCarreras(text = "Licenciatura en ing en sistemas", onClick = {})
        TextBoxCarreras(text = "Licenciatura en ing en Infirmatica", onClick = {})
        TextBoxCarreras(text = "Licenciatura en ing en indistrual", onClick = {})
        TextBoxCarreras(text = "Licenciatura en ing en electronica", onClick = {})


    }
}

@Composable
fun TextBoxCarreras(
    text: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .background(
                color = Color(0xFFD1D8FF),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 6.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            color = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.fecha),
            contentDescription = stringResource(R.string.arrow_icon),
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = { Text(stringResource(R.string.text_searchbar), fontSize = 10.sp) },
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
            .wrapContentHeight()
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        ),
        shape = RoundedCornerShape(8.dp)
    )


}
