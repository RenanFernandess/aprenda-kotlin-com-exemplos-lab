package com.desafio.cli

import com.desafio.Usuario
import com.desafio.data.database.Formacoes

class InterfaceCLI(
    private val formacoes: Formacoes,
) {

    fun iniciar() {
        println("Bem vindo(a) ao nosso terminal de formações!")
        println("Como posso te ajudar?")
        println("   1 - Ver lista de formações \n   2 - Matricular em um curso \n   3 - Fazer login")
        println("Digite o numero da opção desejada para prosseguir!")
        val opcao: String = readln()

//        while (opcao !in 1..3) {
//            opcao = readln().toInt()
//        }

        when(opcao) {
            "1" -> listarCursos()
            "2" -> fazerMatricula()
            "3" -> fazerLogin()
        }
    }

    private fun listarCursos() {
        println("---------Aqui esta nossa grade de cursos!---------")
        val listaDeCursos = formacoes.data
            .foldIndexed("") { ind, acc, next -> acc + "    ${ind+1} - ${next.nome}\n" }

        println(listaDeCursos)
        println("Digite o numero do curso para ver os detalhes ou digite 0 para voltar")
        val numeroDoCurso: Int = readln().toInt()
        val index: Int = numeroDoCurso -1

        when(numeroDoCurso) {
            in 1..formacoes.data.size -> verDetalhesDoCurso(index)
            0 -> return
        }
    }

    private fun verDetalhesDoCurso(index: Int) {
        val curso = formacoes.data[index]
        curso.run {
            val conteudosDoCurso = conteudos
                .foldIndexed("") { ind, acc, next -> acc + "    ${ind+1} - ${next.nome}: ${next.duracao}min\n"}

            println("---------Detalhes do curso $nome---------")
            println("Nível: $nivel")
            println("Conteúdos do curso:")
            println(conteudosDoCurso)
        }

        println("Como você deseja prosseguir?")
        println("   1 - Matricular no curso\n   2 - Ver lista de inscritos\n    3 - Voltar para lista de cursos\n   4 - Voltar para o inicio")

        val opcao: String = readln()
        println("Digite o numero da opção desejada para prosseguir!")

        when(opcao) {
            "1" -> fazerMatricula()
            "2" -> listarInscritosDoCurso(curso.listarInscritos())
            "3" -> return
            "4" -> return
        }
    }

    private fun listarInscritosDoCurso(inscritos: String) {
        println("Lista de inscritos:")
        println(inscritos)
    }

    private fun fazerMatricula() {}
    private fun fazerLogin() {}
}