package com.example.a511lasalleapp.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a511lasalleapp.R
import com.example.a511lasalleapp.ui.theme.White
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.ui.theme.components.GradeCard
import com.example.a511lasalleapp.utils.Screens
import com.example.a511lasalleapp.utils.alumno
import com.example.a511lasalleapp.utils.meses

@Composable
fun PagosScreen(innerPadding: PaddingValues, navController: NavController){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            ,

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
                text = stringResource(id = R.string.pagos),
                style = MaterialTheme.typography.titleLarge,
                color = White,
                modifier = Modifier.padding(10.dp)
            )
        }


        Text(
            text = "Pagos de colegiatura:",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
            ,
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "Meses Pagados",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                fontWeight = FontWeight.Bold
            )

            Column {
                meses.forEach { mes ->
                    if (mes.estadoPagado) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)

                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Color(0xFFDEE2E6)),

                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 2.dp, horizontal = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically

                                ){
                                    Text(
                                        text = mes.nombreMes,
                                        modifier = Modifier.padding(4.dp)
                                    )

                                    // Selección de imagen según el estado pagado
                                    val imageResource = if (mes.estadoPagado) {
                                        R.drawable.icon_pagado // Imagen si está pagado
                                    } else {
                                        R.drawable.icon_adeudo // Imagen si no está pagado
                                    }

                                    Icon(
                                        painter = painterResource(id = imageResource),
                                        contentDescription = if (mes.estadoPagado) "Pagado" else "No pagado",
                                        tint = Color.Unspecified,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                            }
                        }
                    }
                }
            }

            Text(
                text = "Meses Adeudados",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                fontWeight = FontWeight.Bold
            )

            Column(
                modifier = Modifier.padding(bottom = 10.dp)
            ){
                meses.forEach { mes ->
                    if (mes.estadoPagado == false) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)

                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Color(0xFFDEE2E6)),

                                ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 2.dp, horizontal = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically

                                ){
                                    Text(
                                        text = mes.nombreMes,
                                        modifier = Modifier.padding(4.dp)
                                    )

                                    // Selección de imagen según el estado pagado
                                    val imageResource = if (mes.estadoPagado) {
                                        R.drawable.icon_pagado // Imagen si está pagado
                                    } else {
                                        R.drawable.icon_adeudo // Imagen si no está pagado
                                    }

                                    Icon(
                                        painter = painterResource(id = imageResource),
                                        contentDescription = if (mes.estadoPagado) "Pagado" else "No pagado",
                                        tint = Color.Unspecified,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier.width(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary)
                .height(50.dp)
                .padding(horizontal = 40.dp, vertical = 15.dp)
                .clickable {
                    navController.navigate("home")
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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PagosScreenPreview(){
    _511LaSalleAppTheme {
        PagosScreen(innerPadding = PaddingValues(0.dp), navController = rememberNavController())
    }
}