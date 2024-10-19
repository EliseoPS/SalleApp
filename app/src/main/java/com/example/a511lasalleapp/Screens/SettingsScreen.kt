package com.example.a511lasalleapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.a511lasalleapp.R
import com.example.a511lasalleapp.ui.theme.White
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.ui.theme.components.CardImage
import com.example.a511lasalleapp.utils.alumno

@Composable
fun SettingsScreen(innerPadding: PaddingValues, navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center,


            ) {
            Text(
                text = stringResource(id = R.string.configuration),
                style = MaterialTheme.typography.titleLarge,
                color = White,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 19.dp)
                .clip(RoundedCornerShape(16.dp))
                .height(380.dp) // Ajusta la altura según sea necesario
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(Color.White)
                    .height(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Primer tercio (gris)
                Box(
                    modifier = Modifier
                        .weight(1f) // 1/3 del espacio total
                        .fillMaxWidth()
                        .background(Color.Gray)
                )

                AsyncImage(
                    model = alumno.image,
                    contentDescription = "AlumnoImg",
                    modifier = Modifier.size(120.dp)
                        .offset(y = (-40).dp)
                        .clip(CircleShape)
                        .border(4.dp, Color.White, CircleShape)
                    )

                // Dos tercios inferiores (blanco)
                Box(
                    modifier = Modifier
                        .weight(2f) // 2/3 del espacio total
                        .fillMaxWidth()
                        .background(Color.White)
                ){
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = alumno.nombre,
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 22.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Fecha de Nacimiento: ") // Esta parte estará en negritas
                                }
                                append(alumno.fechaNacimiento) // Esta parte tendrá el estilo normal
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Correo: ") // Esta parte estará en negritas
                                }
                                append(alumno.correo) // Esta parte tendrá el estilo normal
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 19.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .height(50.dp)
                    .clickable {
                        navController.navigate("cambiarTema")
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Cambiar tema",
                    style = MaterialTheme.typography.bodyLarge,
                    color = White
                )
            }
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .height(50.dp)
                    .clickable {
                        navController.navigate("cambiarContrasena")
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Cambiar Contraseña",
                    style = MaterialTheme.typography.bodyLarge,
                    color = White,
                )
            }

        }


    }





}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SettingsPreview(){
    _511LaSalleAppTheme {
        SettingsScreen(innerPadding = PaddingValues(0.dp), navController = rememberNavController())
    }
}