package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.DropdownMenuItem

package org.scesi.cappuchino

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.reflect.Modifier

@Composable
fun settingsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "Configuraciones", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "mantener El horario al cerrar el navegador")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text ="Modo Oscuro")

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Configuración Visual",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Tamaño de la fuente")
        FZDropDown()

        Text(text = "Estilo de la fuente")
        SFDropDown()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {  }, colors = ButtonDefaults.outlinedButtonColors()) {
                Text(text ="Cancelar")
            }
            Button(onClick = {  }) {
                Text(text ="Guardar")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FZDropDown(){
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
fun SFDropDown(){
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