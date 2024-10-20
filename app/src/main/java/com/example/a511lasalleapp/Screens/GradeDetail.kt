package com.example.a511lasalleapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.a511lasalleapp.R
import com.example.a511lasalleapp.ui.theme.White
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.utils.alumno
import com.example.a511lasalleapp.utils.newsList

@Composable
fun GradesDetailScreen(innerPadding: PaddingValues, gradeId : Int,navController: NavController){
    val materia = alumno.materias.first{it.id == gradeId}
    val myCustomColor = Color(0xFFE9ECEF) // Un color gris claro

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
                text = stringResource(id = R.string.materia),
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
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Tus Calificaciones",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = materia.nombreMateria,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box(
                        modifier = Modifier.size(90.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(myCustomColor)
                            .border(2.dp,Color.DarkGray,RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = ""+materia.calificaciones[0])
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "1er Parcial",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "20%",
                            fontSize = 14.sp
                        )
                    }


                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box(
                        modifier = Modifier.size(90.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(myCustomColor)
                            .border(2.dp,Color.DarkGray,RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = ""+materia.calificaciones[1])
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "2ndo Parcial",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(
                            text = "20%",
                            fontSize = 14.sp
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    Box(
                        modifier = Modifier.size(90.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(myCustomColor)
                            .border(2.dp,Color.DarkGray,RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = ""+materia.calificaciones[2])
                    }
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "3er Parcial",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(
                            text = "60%",
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(myCustomColor)
                        .border(2.dp,Color.DarkGray,RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        modifier = Modifier.padding(vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(text = "Promedio Final: ", fontWeight = FontWeight.Bold)
                        Text(text ="${String.format("%.2f", materia.promedioAcumulado)}")

                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier.width(300.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .height(50.dp)
                    .padding(horizontal = 40.dp)
                    .clickable {
                        navController.navigate("grades")
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Volver",
                    style = MaterialTheme.typography.bodyLarge,
                    color = White,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GradesDetailPreview(){
    _511LaSalleAppTheme {
        GradesDetailScreen(innerPadding = PaddingValues(0.dp), gradeId = 1 ,navController = rememberNavController())
    }
}
