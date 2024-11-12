package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.theme.CappuchinoTheme

@Composable
fun SettingsScreen(){
    SettingsScreenContent()
}

@Composable
private fun SettingsScreenContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(
                text = stringResource(R.string.configuracion),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))

            Text(text = stringResource(R.string.mantener_horario_al_cerrar_el_navegador), modifier = Modifier.padding(8.dp))

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))

            Text(text = stringResource(R.string.modo_oscuro), modifier = Modifier.padding(8.dp))

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))

            Text(
                text = stringResource(R.string.configuracion_visual),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))

            ConfigurationRow(
                title = stringResource(R.string.tama_o_de_la_fuente),
                listsize = listOf(
                    stringResource(R.string.peque_o),
                    stringResource(R.string.mediano),
                    "Grande")
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))

            ConfigurationRow(title = stringResource(R.string.estilo_de_fuente),
                listsize = listOf(stringResource(R.string.calibri),
                    "Puppets",
                    "Arial")
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_padding_size_medium)))
            Text(text = stringResource(R.string.temas))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            CappuchinoButton(
                title = stringResource(R.string.cancelar),
                contentColor = Color.Black,
                contarinerColor = Color.White,
                borderColor = Color.Gray)

            CappuchinoButton(
                title = stringResource(R.string.guardar),
                contentColor = Color.White,
                contarinerColor = Color.Black,
                borderColor = Color.Black)

        }
    }
}

@Composable
fun ConfigurationRow(
    title:String,
    listsize: List<String>
){
    Row {
        Text(
            text = title,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_padding_size_small))
        )

        DropDown(listsize)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(listsize: List<String>){
    var expanded by remember { mutableStateOf(false)}
    var selectedText by remember { mutableStateOf(listsize[0])}
    ExposedDropdownMenuBox(
        expanded = false, onExpandedChange = {expanded = !expanded}
    )
    {
        TextField(
            value = selectedText
            ,onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            listsize.forEachIndexed { index, text ->
                DropdownMenuItem(text = { Text(text = text) }, onClick = {
                    selectedText = listsize[index]
                    expanded = false },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,)
            }
        }
    }
}

@Composable
fun CappuchinoButton(
    title: String,
    contentColor: Color,
    contarinerColor: Color,
    borderColor: Color
){
    Button(onClick = {  },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
            containerColor = contarinerColor
        ),border = BorderStroke(1.dp, borderColor),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_padding_size_small))
    ) {
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview(){
    CappuchinoTheme {
        SettingsScreen()
    }
}
