import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.scesi.cappuchino.R


@Composable
fun AboutScreen() {
    val state = AboutState()
    AboutContent(state)
}


@Composable
fun AboutContent(state: AboutState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(R.string.conoce_m_s_sobre_cappuchino),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red,
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(R.dimen.font_size_title).value.sp
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

            Text(
                text = stringResource(R.string.cappuchino_es_un_sistema_que_facilita_la_gesti_n_de_horarios_a_los_estudiantes_de_la_facultad_de_ciencias_y_tecnolog_a_de_la_universidad_mayor_de_san_sim_n),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(R.dimen.font_size_body).value.sp
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.desarrollado_por),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = stringResource(R.string.scesi_umss),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
            }
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF101126)),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(dimensionResource(R.dimen.button_height)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = stringResource(R.string.ir_al_webcito))
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Text(
            text = stringResource(R.string.similares_a_cappuchino),
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            fontSize = dimensionResource(R.dimen.font_size_title).value.sp
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.box_size))
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Espresso", fontSize = dimensionResource(R.dimen.font_size_body).value.sp)
            }
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.box_size))
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.frappuchino), fontSize = dimensionResource(R.dimen.font_size_body).value.sp)
            }
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
    }
}



@Composable
fun AboutScreenPreview() {
    AboutContent(state = AboutState())
}

data class AboutState(
    val title: String = "Cappuchino"
)
