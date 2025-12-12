package com.desafio.cli

import com.desafio.data.models.User
import com.desafio.data.database.Courses
import com.desafio.data.models.Sex

class InterfaceCLI(
    private val formations: Courses,
) {

    fun start() {
        var close: Boolean = false
        while (!close) {
            println("Bem vindo(a) ao nosso terminal de formações! \n Como posso te ajudar?")
            println("   1 - Ver lista de formações \n   2 - Matricular em um curso \n   Sair - Digite 'sair' para encerrar")
            print("Digite o numero da opção desejada para prosseguir!\n--> ")
            val option: String = getOption("1".."2")
            when(option) {
                "1" -> close = listCourses()
                "2" -> ""
                "sair" -> close = true
            }
        }
    }

    private fun listCourses(): Boolean {
        var close: Boolean = false
        val numberOfCourses = formations.data.size.toString()
        val coursesList = formations.listCourses()
        while (!close) {
            println("---------Aqui esta nossa grade de cursos!---------")
            println(coursesList)
            print("Digite o numero do curso para ver os detalhes ou digite 0 para voltar\n--> ")
            when(val option: String = getOption("0"..numberOfCourses)) {
                in "1"..numberOfCourses -> close = showCourseDetails(option.toInt()-1)
                "0" -> close = true
            }
        }
        return false
    }

    private fun showCourseDetails(index: Int): Boolean {
        var close: Boolean = false
        val course = formations.data[index]
        while (!close) {
            course.run {
                val title = "---------Detalhes do curso $title---------"
                println(title)
                println("Nível: $levelOfEducation\nConteúdos do curso:\n${listContents()}")
                println("-".repeat(title.length))
            }
            println("Como você deseja prosseguir?")
            println("   1 - Matricular no curso\n   2 - Ver lista de inscritos\n   3 - Voltar para lista de cursos\n   4 - Voltar para o inicio")
            print("Digite o numero da opção desejada para prosseguir!\n--> ")
            val option: String = getOption("1".."4")
            when(option) {
                "1" -> enroll(index)
                "2" -> println("Lista de inscritos:\n${course.listEnrolled()}")
                "3" -> close = true
                "4" -> return true
            }
        }
        return false
    }

    private fun enroll(index: Int) {
        val course = formations.data[index]
        println("Matricular no curso de ${course.title}")
        println("Para realizar a matricula no curso preencha as informações a seguir:")
        var user: User = collectUserData()
        var isCorrect = checkUserData(user)
        while (!isCorrect) {
            println("Preencha os dados novamente:")
            user = collectUserData()
            isCorrect = checkUserData(user)
        }

        val isEnrolled: Boolean = course.enroll(user)
        if (isEnrolled) {
            user.run {
                val message =
                    if (sex == Sex.FEMININO) "matriculada com sucesso!"
                    else "matriculado com sucesso!"
                println("$name $lastName $message")
            }
        }
    }

    private fun collectUserData(): User {
        print("Nome: ")
        val firstName: String = readln()
        print("Sobrenome: ")
        val lastName: String = readln()
        print("Idade: ")
        val age: Int = getAge()
        println("Sexo:\n   M - Masculino\n   F - Feminino")
        val sex: Sex = getSex()
        return User(firstName, lastName, age, sex)
    }

    fun checkUserData(user: User): Boolean {
        println("Confira se as informações estão corretas!")
        user.run {
            println("   Nome: $name $lastName\n   Idade: $age\n   Sexo: ${sex.toString()}\n")
        }
        println("Como você deseja prosseguir?")
        println("   1 - Sim, continuar matricula\n   2 - Não, corrigir informações")
        print("Digite o numero da opção desejada para prosseguir!\n--> ")
        val option: String = getOption("1".."2", false)
        return when(option) { "1" -> true; else -> false }
    }

    private fun getAge(): Int {
        val regex = Regex("^[0-9]{2}$")
        var age: String = readln()
        while (!age.contains(regex)) {
            print("$age não é uma idade valida! Digite uma idade entre 10 a 99 anos.\n--> ")
            age = readln()
        }
        return age.toInt()
    }

    private fun getSex(): Sex {
        val regex = Regex("^[MmFf]$")
        var sex: String = readln()
        while (!sex.contains(regex)) {
            print("$sex não é uma opção valida! Digite o carácter da opção desejada novamente.\n--> ")
            sex = readln()
        }
        sex.lowercase()
        return when(sex) {"f" -> Sex.FEMININO; else -> Sex.MASCULINO}
    }

    private fun getOption(range: ClosedRange<String>, exit: Boolean = true): String {
        var option: String = readln().lowercase()
        if (option == "sair" && exit) return option
        while (option !in range) {
            print("$option não é uma opção valida! Digite o numero da opção desejada novamente.\n--> ")
            option = readln()
        }
        return option
    }
}