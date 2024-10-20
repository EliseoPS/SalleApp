package com.example.a511lasalleapp.models

data class Materia(
    val id : Int,
    val nombreMateria : String,
    var promedioAcumulado : Double,
    val calificaciones : List<Double>
)
