package com.example.a511lasalleapp.utils

sealed class Screens(val route : String) {
    data object Home : Screens("home")
    data object Grades : Screens("grades")
    data object Calendar : Screens("calendar")
    data object Settings : Screens("settings")
    data object NewDetail : Screens("newDetail")
    data object MateriaDetail : Screens("materiaDetail")
    data object CambiarContrasena : Screens("cambiarContrasena")
    data object CambiarTema : Screens("cambiarTema")

}