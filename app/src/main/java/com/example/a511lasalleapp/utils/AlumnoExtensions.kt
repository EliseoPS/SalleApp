package com.example.a511lasalleapp.utils

import com.example.a511lasalleapp.models.Materia
import com.example.a511lasalleapp.models.User

fun Materia.calcularPromedio() : Double{
    if (calificaciones.isNotEmpty()){
        val totalPromedioMateria = ( (calificaciones[0]*.20) + (calificaciones[1]*.20) + (calificaciones[2]*.60) )
        promedioAcumulado = totalPromedioMateria
        return promedioAcumulado
    }
    else{
        promedioAcumulado = 0.0
        return promedioAcumulado
    }
}

fun User.calcularPromedioGeneral(): Double {
    val totalPromedios = materias.sumOf { it.calcularPromedio() }
    return if (materias.isNotEmpty()) {
        totalPromedios / materias.size
    } else {
        0.0
    }
}

