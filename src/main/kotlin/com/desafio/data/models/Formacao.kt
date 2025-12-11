package data.models

import kotlin.Usuario

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    private val _inscritos: MutableList<Usuario> = mutableListOf()
    val inscritos: List<Usuario> get() = _inscritos

    fun matricular(usuario: Usuario) {
        if (_inscritos.add(usuario)) {
            val nomeUsuario = "${usuario.nome} ${usuario.sobreNome}"
            val message = when(usuario.sexo) {
                Sexo.MASCULINO -> "$nomeUsuario matriculado com sucesso"
                Sexo.FEMININO -> "$nomeUsuario matriculada com sucesso"
            }
            println(message)
        }
    }

    fun matricularVarios(vararg usuarios: Usuario) {
        if (_inscritos.addAll(usuarios)) {
            val names: String = usuarios
                .fold("") { acc, next -> acc + "${next.nome} ${next.sobreNome}, " }
                .dropLast(2)
            println("$names foram matriculados com sucesso!")
        }
    }

    fun listarConteudos (): List<String> = conteudos.map { it.nome }

    fun listarInscritos (): List<String> = inscritos.map { "${it.nome} ${it.sobreNome}" }
}