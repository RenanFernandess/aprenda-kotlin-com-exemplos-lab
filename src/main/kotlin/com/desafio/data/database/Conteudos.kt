package com.desafio.data.database

import com.desafio.data.models.EducationalContent

object Conteudos {
    val desenvolvimentoWeb: List<EducationalContent> = listOf(
        EducationalContent("Fundamentos", 80),
        EducationalContent("Java-script"),
        EducationalContent("Front-end", 120),
        EducationalContent("Back-end", 120),
        EducationalContent("Ciencias da computação")
    )
}