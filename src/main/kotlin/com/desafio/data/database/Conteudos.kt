package com.desafio.data.database

import com.desafio.data.models.ConteudoEducacional

object Conteudos {
    val desenvolvimentoWeb: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Fundamentos", 80),
        ConteudoEducacional("Java-script"),
        ConteudoEducacional("Front-end", 120),
        ConteudoEducacional("Back-end", 120),
        ConteudoEducacional("Ciencias da computação")
    )
}