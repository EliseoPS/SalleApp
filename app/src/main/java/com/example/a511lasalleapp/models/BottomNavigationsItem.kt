package com.example.a511lasalleapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.a511lasalleapp.utils.Screens

data class BottomNavigationsItem(
    val title : String,
    val icon : ImageVector,
    val route : String
){
    companion object{
        val items = listOf(
            BottomNavigationsItem(
                title = "Inicio",
                icon = Icons.Default.Home,
                route = Screens.Home.route
            ),
            BottomNavigationsItem(
                title = "Calificaciones",
                icon = Icons.Default.Menu,
                route = Screens.Grades.route

            ),
            BottomNavigationsItem(
                title = "Calendario",
                icon = Icons.Default.DateRange,
                route = Screens.Calendar.route
            ),
            BottomNavigationsItem(
                title = "Configuración",
                icon = Icons.Default.Settings,
                route = Screens.Settings.route
            ),
        )
    }
}