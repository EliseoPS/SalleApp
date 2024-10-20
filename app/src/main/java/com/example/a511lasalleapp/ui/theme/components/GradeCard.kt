package com.example.a511lasalleapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.a511lasalleapp.Screens.CambiarTemaScreen
import com.example.a511lasalleapp.models.Materia
import com.example.a511lasalleapp.models.News
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme


@Composable
fun GradeCard(materia: Materia, onClick: (Materia)->Unit){
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xdee2e6))
            .clickable {
                onClick(materia)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xdee2e6))

    ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFDEE2E6)),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically

            ){
                Text(
                    text = materia.nombreMateria,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = String.format("Promedio: %.2f", materia.promedioAcumulado),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End

                )
            }

        }
    }
}
