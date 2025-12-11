package com.desafio.cli

import com.desafio.data.database.Formacoes
import com.desafio.data.models.Formacao

class Interface(
    private val formacoes: Formacoes,
) {

    fun apresentar() {
        println("Bem vindo(a) ao nosso terminal de formações!")
        println("Como posso te ajudar?")
        println("   1 - Ver lista de formações \n   2 - Matricular em um curso \n   3 - Fazer login")
        println("Digite o numero da opção desejada para prosseguir...")
        val opcao: Int = readln().toInt()

//        while (opcao !in 1..3) {
//            opcao = readln().toInt()
//        }

        when(opcao) {
            1 -> listarCursos()
            2 -> fazerMatricula()
            3 -> fazerLogin()
        }
    }

    private fun listarCursos() {
        println("Aqui esta nossa grade de cursos")
        val listaDeCursos = formacoes.listarNomeDeCursos()

        println(listaDeCursos)
    }
    private fun fazerMatricula() {}
    private fun fazerLogin() {}
}