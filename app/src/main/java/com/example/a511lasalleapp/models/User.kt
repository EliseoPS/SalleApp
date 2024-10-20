package com.example.a511lasalleapp.models

data class User(
    val id : Int,
    val nombre : String,
    val fechaNacimiento : String,
    val correo : String,
    val image : String,
    val carrera: String,
    val semestreActual: Int,
    val promedioAcumulado: Double,
    val materias: List<Materia>
)
