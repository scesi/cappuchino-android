
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "CAPPUCHINO",
            style = MaterialTheme.typography.h6,
            color = Color.DarkGray,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "CONOCE MÁS SOBRE CAPPUCHINO",
                style = MaterialTheme.typography.subtitle1,
                color = Color.Red,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Cappuchino es un sistema que facilita la gestión de horarios a los estudiantes de la Facultad de Ciencias y Tecnología de la Universidad Mayor de San Simón.",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Desarrollado por:")
                Spacer(modifier = Modifier.width(8.dp))

            }
        }

        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Ir al Webcito")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Similares a Cappuchino",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray)
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Espresso")
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray)
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Frappuchino")
            }
        }



    }
}
