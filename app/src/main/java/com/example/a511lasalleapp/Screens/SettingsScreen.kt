package com.example.a511lasalleapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center,


            ){
            Text(
                text = stringResource(id = R.string.configuration),
                style = MaterialTheme.typography.titleLarge,
                color = White,
                modifier = Modifier.padding(10.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 14.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color.Gray)
                .height(100.dp)
        ){


        }
        AsyncImage(
            model = alumno.image,
            contentDescription = "AlumnoImg",
            modifier = Modifier.size(120.dp)
                .offset(y = (-40).dp)
                .clip(CircleShape)
                .border(4.dp, Color.White, CircleShape)
                .zIndex(1f),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .offset(y = (-120).dp)
                .padding(horizontal = 14.dp)
                .background(Color.White)
                .height(100.dp)

        ){

        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 14.dp)
                .offset(y = (-120).dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(Color.White)
                .height(190.dp)

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
        Row(
            modifier = Modifier.fillMaxWidth()
                .offset(y = -(50).dp)
                .padding(horizontal = 20.dp)
                .background(Color.Green)
                .height(100.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ){
            Box(
                modifier = Modifier.fillMaxHeight()
                    .size(100.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Red)
            ){

            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Red)
            ){

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