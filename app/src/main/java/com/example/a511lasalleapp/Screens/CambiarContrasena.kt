package com.example.a511lasalleapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.a511lasalleapp.utils.Screens



@Composable
fun CambiarContrasenaScreen(innerPadding: PaddingValues, navController: NavController){
    var text = ""


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
                text = stringResource(id = R.string.cambiarContra),
                style = MaterialTheme.typography.titleLarge,
                color = White,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Text(
            text = "Llene el siguiente formulario:",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)

            )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        Column(

            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(horizontal = 16.dp)

        ){

            OutlinedTextField(
                value = "",
                onValueChange = { newText -> text = newText },
                label = { Text("Contraseña Actual") }, // Esto se ve cuando el campo está activo
                // Placeholder
                modifier = Modifier
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = "",
                onValueChange = { newText -> text = newText },
                label = { Text("Nueva contraseña") }, // Esto se ve cuando el campo está activo
                // Placeholder
                modifier = Modifier
                    .fillMaxWidth()

            )


        }
        Spacer(
            modifier = Modifier.height(50.dp)
        )
        //CAMBIAR
        Box(
            modifier = Modifier.width(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary)
                .height(50.dp)
                .padding(horizontal = 40.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Cambiar",
                style = MaterialTheme.typography.bodyLarge,
                color = White,
            )
        }
        Spacer(
            modifier = Modifier.height(50.dp)
        )
        //VOLVER
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
fun CambiarContrasenaScreen(){
    _511LaSalleAppTheme {
        CambiarContrasenaScreen(innerPadding = PaddingValues(0.dp), navController = rememberNavController())
    }
}