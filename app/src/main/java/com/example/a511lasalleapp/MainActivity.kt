package com.example.a511lasalleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a511lasalleapp.Screens.*
import com.example.a511lasalleapp.models.BottomNavigationsItem
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.utils.Screens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var selectedItem by rememberSaveable{
                mutableIntStateOf(0)
            }
            _511LaSalleAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedNavigationBar(
                            selectedIndex = selectedItem,
                            modifier = Modifier.height(100.dp),
                            barColor = MaterialTheme.colorScheme.primary,
                            cornerRadius = shapeCornerRadius(cornerRadius = 34.dp)
                        ){
                            BottomNavigationsItem.items.forEachIndexed{index, bottomNavigationsItem ->
                                Column(
                                    modifier = Modifier.fillMaxSize().clickable{
                                        selectedItem = index
                                        navController.navigate(bottomNavigationsItem.route)
                                    },
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center

                                ){
                                    Icon(imageVector = bottomNavigationsItem.icon,
                                        contentDescription = bottomNavigationsItem.title,
                                        tint = if(selectedItem == index) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text(bottomNavigationsItem.title, color = MaterialTheme.colorScheme.onPrimary, style = MaterialTheme.typography.bodySmall)
                                }
                            }


                        }
                    }) { innerPadding ->

                    NavHost(navController = navController, startDestination = Screens.Home.route){
                        composable(route = Screens.Home.route){
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Grades.route){
                            GradesScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.Calendar.route){
                            CalendarScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.Settings.route)
                        {
                            SettingsScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(
                            route = Screens.NewDetail.route+"/{newsId}",
                            arguments = listOf(
                                navArgument("newsId")
                                {
                                    type=NavType.IntType
                                }
                            )
                        )
                        {
                            val newsId = it.arguments?.getInt("newsId") ?: 0
                            NewsDetailScreen(innerPadding = innerPadding, newsId = newsId)
                        }
                        composable(route = Screens.CambiarContrasena.route)
                        {
                            CambiarContrasenaScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.CambiarTema.route)
                        {
                            CambiarTemaScreen(innerPadding = innerPadding, navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _511LaSalleAppTheme {
        Greeting("Android")
    }
}