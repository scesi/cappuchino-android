import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Espaciado inicial
        Spacer(modifier = Modifier.height(30.dp))

        // Sección de información
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // Título en rojo
            Text(
                text = "CONOCE MÁS SOBRE CAPPUCHINO",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción
            Text(
                text = "Cappuchino es un sistema que facilita la gestión de horarios a los estudiantes de la Facultad de Ciencias y Tecnología de la Universidad Mayor de San Simón.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Texto de desarrollo con imagen
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Desarrollado por:",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.scesi_logo), // Reemplaza con tu recurso de imagen
                    contentDescription = "Logo SCESI",
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Texto adicional con SCESI en rojo
            Text(
                text = buildAnnotatedString {
                    append("¡Visítanos en nuestra web para saber más de ")
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("SCESI")
                    }
                    append("!")
                },
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de navegación
        Button(
            onClick = { /* Acción al hacer clic */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF101126)), // Color del botón
            modifier = Modifier
                .fillMaxWidth(0.7f) // Ajusta el tamaño del botón
                .height(48.dp),     // Altura del botón
            shape = RoundedCornerShape(8.dp) // Bordes redondeados
        ) {
            Text(text = "Ir al Webcito", color = Color.White) // Texto en blanco
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto de "Similares"
        Text(
            text = "Similares a Cappuchino",
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Opciones similares
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .clickable { /* Acción para Espresso */ },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Espresso", fontSize = 14.sp)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .clickable { /* Acción para Frappuchino */ },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Frappuchino", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado final
    }
}
