package com.desafio

import com.desafio.cli.InterfaceCLI
import com.desafio.data.database.Formacoes

fun main(args: Array<String>) {
    val formacoes = Formacoes
    formacoes.iniciar()

    val interfaceCLI = InterfaceCLI(formacoes)

    interfaceCLI.iniciar()
}
