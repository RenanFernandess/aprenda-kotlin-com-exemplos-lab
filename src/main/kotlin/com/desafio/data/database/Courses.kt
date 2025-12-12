package com.desafio.data.database

import com.desafio.data.models.User
import com.desafio.data.models.Course
import com.desafio.data.models.LevelOfEducation
import com.desafio.data.models.Sex

object Courses {
    private val _data: MutableList<Course> = mutableListOf()
    val data: List<Course> get() = _data

    fun start() {
        val course = Course(
            title = "Desenvolvimento Web",
            levelOfEducation = LevelOfEducation.INTERMEDIARIO,
            contents = Conteudos.desenvolvimentoWeb
        )

        course.enrollAll(
            User(
                "João",
                "Paulo",
                28,
                Sex.MASCULINO
            ),
            User(
                "Maria",
                "Luisa",
                25,
                Sex.FEMININO
            )
        )

        _data.add(course)
    }

    fun listCourses() = data
        .foldIndexed("") { ind, acc, next -> acc + "    ${ind+1} - ${next.title}\n" }

}