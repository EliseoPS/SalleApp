package com.example.a511lasalleapp.Screens

import Cash
import Logout
import Task
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.a511lasalleapp.R
import com.example.a511lasalleapp.models.Community
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.ui.theme.components.CardImage
import com.example.a511lasalleapp.ui.theme.components.Widget
import com.example.a511lasalleapp.utils.Screens
import com.example.a511lasalleapp.utils.communities
import com.example.a511lasalleapp.utils.newsList

@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())


    ){
        Box(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                .height(270.dp)
                .background(MaterialTheme.colorScheme.primary)
                .padding(innerPadding)
        ){
            Image(
                painter = painterResource(R.drawable.backgroundimg),
                contentDescription = "Background",
                modifier = Modifier.fillMaxWidth().offset(y = 80.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(painter = painterResource(id = R.drawable.logosalle),
                    contentDescription = "logo",
                    modifier = Modifier.size(70.dp))
                Column(
                    modifier = Modifier.padding(start = 10.dp).weight(1f)
                ){
                    Text(text = stringResource(id = R.string.welcome_text), color = MaterialTheme.colorScheme.onPrimary, fontSize = 18.sp)
                    Text(text = "Eliseo Paredes", color = MaterialTheme.colorScheme.onPrimary, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                }
                Icon(
                    imageVector = Logout,
                    contentDescription = "Logout",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )

            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .offset(y = (-50).dp)
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .height(140.dp),
            contentAlignment = Alignment.Center


        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Widget(icon = Icons.Default.DateRange, title = "Sin eventos")
                Widget(icon = Task, title = "2 tareas")
                Widget(icon = Cash, title = "Pagos")

            }

        }
        Box(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ){
            Column(

            ){
                Text(text = stringResource(id = R.string.news), style = MaterialTheme.typography.titleLarge)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(newsList){ news ->
                        CardImage(news = news){
                            navController.navigate(Screens.NewDetail.route+"/${news.id}")
                            Log.i("News",it.id.toString())
                        }
                    }
                }
                Text(text = stringResource(id = R.string.community),
                    style = MaterialTheme.typography.titleLarge)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                ){
                    items(communities){ community ->
                        Box(
                            modifier = Modifier.size(180.dp)
                                .padding(16.dp)
                        ){
                            AsyncImage(
                                model = community.image, contentDescription = "community",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
            
            //GRID COMUNIDAD

        }
    }

}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    _511LaSalleAppTheme {
        val navController = rememberNavController()
        HomeScreen(innerPadding = PaddingValues(0.dp), navController = navController)
    }
}