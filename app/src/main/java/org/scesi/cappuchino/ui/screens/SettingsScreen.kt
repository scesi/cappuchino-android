package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.scesi.cappuchino.R
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview( showBackground = true)
@Composable
fun SettingsScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(

        ) {
            Text(
                text = "CONFIGURACION",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Mantener horario al cerrar el navegador", modifier = Modifier.padding(8.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Modo Oscuro", modifier = Modifier.padding(8.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "CONFIGURACION VISUAL",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(text = "Tamaño de la fuente",
                    modifier = Modifier.padding(8.dp))

                DropDownTamanioFuente()

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Estilo de fuente",
                    modifier = Modifier.padding(8.dp))

                DropDownStyles()
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Temas")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = {  },
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                ),border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text ="Cancelar")
            }
            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ), shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(8.dp)
            ){
                Text(text ="Guardar")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownTamanioFuente(){
    val listsize = listOf("Pequeño", "Mediano", "Grande")
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
                    expanded = false
                },
                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownStyles(){
    val listsize = listOf("Calibri", "Arial", "Otro")
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
                    expanded = false
                },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,)
            }
        }
    }
}