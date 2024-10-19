package com.example.a511lasalleapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a511lasalleapp.R
import com.example.a511lasalleapp.ui.theme.White
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme

@Composable
fun CambiarTemaScreen(innerPadding: PaddingValues, navController: NavController){
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
                text = stringResource(id = R.string.cambiarTema),
                style = MaterialTheme.typography.titleLarge,
                color = White,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Text(
            text = "Elige un tema:",
            style = MaterialTheme.typography.titleLarge,

        )

        Spacer(
            modifier = Modifier.height(117.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                ,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier.size(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .border(2.dp,Color.DarkGray,RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.sol),
                        contentDescription = "LightMode",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la Box y el texto
                Text("Modo Claro")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier.size(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.DarkGray)
                        .border(2.dp,Color.White,RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.luna),
                        contentDescription = "DarkMode",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la Box y el texto
                Text("Modo Obscuro")
            }
        }
        Spacer(
            modifier = Modifier.height(117.dp)
        )
        Box(
            modifier = Modifier.width(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary)
                .height(50.dp)
                .padding(horizontal = 40.dp)
                .clickable {
                    navController.navigate("settings")
                },
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Volver",
                style = MaterialTheme.typography.bodyLarge,
                color = White,
            )
        }
    }

}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CambiarTemaPreview(){
    _511LaSalleAppTheme {
        CambiarTemaScreen(innerPadding = PaddingValues(0.dp), navController = rememberNavController())
    }
}