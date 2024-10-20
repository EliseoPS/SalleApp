package com.example.a511lasalleapp.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.a511lasalleapp.models.BottomNavigationsItem.Companion.items
import com.example.a511lasalleapp.models.Materia
import com.example.a511lasalleapp.models.User
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.utils.calcularPromedioGeneral
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.a511lasalleapp.R
import com.example.a511lasalleapp.ui.theme.White
import com.example.a511lasalleapp.ui.theme.components.CardImage
import com.example.a511lasalleapp.ui.theme.components.GradeCard
import com.example.a511lasalleapp.utils.Screens
import com.example.a511lasalleapp.utils.alumno
import com.example.a511lasalleapp.utils.newsList

@Composable
fun GradesScreen(innerPadding: PaddingValues,navController: NavController) {
    val promedioGeneral = alumno.calcularPromedioGeneral()

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
                text = stringResource(id = R.string.calificaciones),
                style = MaterialTheme.typography.titleLarge,
                color = White,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(13.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        ){

            Row(
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .padding(10.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ){
                AsyncImage(
                    model = alumno.image,
                    contentDescription = "AlumnoImg",
                    modifier = Modifier.size(150.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Red, CircleShape)
                )
                Column {
                    Text(
                        text = alumno.nombre,
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 14.dp)
                    )
                    Text(
                        text = alumno.carrera,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 14.dp)
                    )
                    Text(
                        text = "Semestre: " + alumno.semestreActual + "to",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 14.dp)
                    )
                    Text(
                        text = "Promedio: $promedioGeneral ",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 14.dp)
                    )
                }

            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = "Materias:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
                    ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                items(alumno.materias){ materia ->
                    GradeCard(materia = materia){
                        navController.navigate(Screens.MateriaDetail.route+"/${materia.id}")
                        Log.i("Materias",it.id.toString())
                    }

                }
            }




        }
    }//Columna grande
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GradesPreview(){
    _511LaSalleAppTheme {
        GradesScreen(innerPadding = PaddingValues(0.dp), navController = rememberNavController())
    }
}