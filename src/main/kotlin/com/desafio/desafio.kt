package com.desafio

import com.desafio.cli.InterfaceCLI
import com.desafio.data.database.Courses

fun main(args: Array<String>) {
    val courses = Courses
    courses.start()
    val interfaceCLI = InterfaceCLI(courses)
    interfaceCLI.start()
}
