package com.example.a511lasalleapp.utils

import com.example.a511lasalleapp.models.Community
import com.example.a511lasalleapp.models.Materia
import com.example.a511lasalleapp.models.News
import com.example.a511lasalleapp.models.User

val newsList = listOf(
    News(    id = 1,    title = "Evento de Construcción de la Paz",    description = "La Salle Bajío realiza un foro para fomentar la construcción de la paz en la comunidad estudiantil.",    image =  "https://www.lasallebajio.edu.mx/noticias/images/4701_1.jpg"),
    News(    id = 2,    title = "Conferencia de Liderazgo",    description = "Una conferencia que destaca la importancia del liderazgo en la comunidad universitaria.",    image = "https://www.lasallebajio.edu.mx/noticias/images/4701_2.jpg"),
    News(    id = 3,    title = "Semana Cultural 2024",    description = "Celebración anual de la Semana Cultural con diversas actividades artísticas y deportivas.",    image = "https://www.lasallebajio.edu.mx/noticias/images/4701_3.jpg")
)

val communities = listOf(
    Community(1,"https://www.lasallebajio.edu.mx/comunidad/images/tile_documentos_inspiradores.jpg"),
    Community(2,"https://www.lasallebajio.edu.mx/comunidad/images/tile_boletin.jpg"),
    Community(3,"https://www.lasallebajio.edu.mx/comunidad/images/tile_cat_souv_22.jpg  "),
    Community(4,"https://www.lasallebajio.edu.mx/comunidad/images/tile_tramites.jpg"),    Community(5,"https://www.lasallebajio.edu.mx/comunidad/images/tile_blog.jpg"),)

val alumno =
    User(
        id = 1,
        nombre = "Eliseo Paredes Sánchez",
        fechaNacimiento = "23-04-2004",
        correo="eliseo@lasalle.edu.mx",
        image = "https://headshots-inc.com/wp-content/uploads/2023/03/business-headshot-example-2.jpg",
        carrera = "Ing. en Sistemas",
        semestreActual = 5,
        promedioAcumulado = 0.0,
        materias = listOf(
            Materia(
                id = 1,
                nombreMateria = "Taller de Programación en Kotlin",
                promedioAcumulado = 0.0,
                calificaciones = listOf(9.0, 8.8, 9.5)
            ),
            Materia(
                id = 2,
                nombreMateria = "Bases de Datos",
                promedioAcumulado = 0.0,
                calificaciones = listOf(8.5, 8.0, 9.1)
            ),
            Materia(
                id = 3,
                nombreMateria = "Modelos Abstractos en Software",
                promedioAcumulado = 0.0,
                calificaciones = listOf(8.0, 7.8, 8.2)
            ),
            Materia(
                id = 4,
                nombreMateria = "Conmutación en Redes",
                promedioAcumulado = 0.0,
                calificaciones = listOf(9.0, 8.8, 9.2)
            ),
            Materia(
                id = 5,
                nombreMateria = "Modelado y Procesamiento de imágenes",
                promedioAcumulado = 0.0,
                calificaciones = listOf(8.7, 8.9, 9.0)
            )
        )
    )
