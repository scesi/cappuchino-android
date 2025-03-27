package org.scesi.cappuchino.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.scesi.cappuchino.R
import org.scesi.cappuchino.ui.CappuchinoState
import org.scesi.cappuchino.ui.theme.CappuchinoTheme

@Composable
fun SettingsScreen(
    navController: NavController,
    cappuchinoState: CappuchinoState
){
    CappuchinoScaffold("Cappuchino", navController, cappuchinoState){
        SettingsScreenContent() //Scaffold añadido anteriormente
    }
}

@Composable
private fun SettingsScreenContent(){
    val sources = listOf(
        stringResource(id = R.string.arial), 
        stringResource(id = R.string.Calibri), 
        stringResource(id = R.string.Poppins)
    )
    val sizes = listOf(
        stringResource(id = R.string.Pequeño), 
        stringResource(id = R.string.Mediano), 
        stringResource(id = R.string.Grande))
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

            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_padding_size_medium))
            )

            Text(
                text = stringResource(R.string.mantener_horario_al_cerrar_el_navegador),
                modifier = Modifier.padding(8.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_padding_size_medium))
            )

            Text(text = stringResource(R.string.modo_oscuro), modifier = Modifier.padding(8.dp))

            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_padding_size_medium))
            )

            Text(
                text = stringResource(R.string.configuracion_visual),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_padding_size_medium))
            )

            ConfigurationRow(
                title = stringResource(R.string.tama_o_de_la_fuente),
                text = stringResource(id = R.string.Mediano),
                sizes
            )

            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_padding_size_medium))
            )

            ConfigurationRow(
                title = stringResource(R.string.estilo_de_fuente),
                text = stringResource(id = R.string.Calibri),
                sources
            )

            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_padding_size_medium)))
            Text(text = stringResource(R.string.temas))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            CappuchinoButton(
                title = stringResource(R.string.cancelar),
                contentColor = Color.Black,
                containerColor = Color.White,
                borderColor = Color.Gray
            )

            Spacer(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.margin_padding_size_small))
            )

            CappuchinoButton(
                title = stringResource(R.string.guardar),
                contentColor = Color.White,
                containerColor = Color.Black,
                borderColor = Color.Black,
            )
        }
    }
}

@Composable
fun ConfigurationRow(
    title:String,
    text: String,
    stringList: List<String>
){
    Row{
        Text(
            text = title,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.margin_padding_size_small))
                .weight(1f)
        )

        CapuchinDropDown(text = text, modifier = Modifier.weight(1f),stringList)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CapuchinDropDown(text: String, modifier: Modifier, stringList: List<String>){
    var bottomSheetState by remember { mutableStateOf(false) }
    var textSelected by remember { mutableStateOf(text)}
    Row(
        modifier = modifier
            .border(
                width = dimensionResource(id = R.dimen.border_line),
                color = Color.Gray,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
            )
            .wrapContentHeight()

    ){
        Row (
            modifier = Modifier
                .clickable {
                    bottomSheetState = true
                }
        ){
            Text(
                text = textSelected, modifier = Modifier
                    .weight(3f)
                    .align(Alignment.CenterVertically)
                    , textAlign = TextAlign.Center
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Drop Down Icon",
                modifier = Modifier
                    .border(
                        width = dimensionResource(id = R.dimen.border_line),
                        color = Color.Gray,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                    )
            )
        }


        if(bottomSheetState) {
            ModalBottomSheet(
                onDismissRequest = { bottomSheetState = false }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    stringList.forEach { stringList ->
                        Text(
                            text = stringList,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    textSelected = stringList
                                    bottomSheetState = false
                                }
                                .padding(dimensionResource(id = R.dimen.margin_padding_size_small)),
                            textAlign = TextAlign.Center
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun CappuchinoButton(
    title: String,
    contentColor: Color,
    containerColor: Color,
    borderColor: Color
){
    Button(onClick = {  },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),border = BorderStroke(dimensionResource(id = R.dimen.border_line), borderColor),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_padding_size_small))
    ) {
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview(){
    CappuchinoTheme {
        SettingsScreen(navController = rememberNavController()  )
    }
}
