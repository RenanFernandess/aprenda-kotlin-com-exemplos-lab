package com.desafio.data.models

import com.desafio.Usuario

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

    fun matricularVarios(vararg usuarios: Usuario): Boolean {
        return _inscritos.addAll(usuarios)
    }

    fun listarConteudos (): List<String> = conteudos.map { it.nome }

    fun listarInscritos (): String = inscritos
        .foldIndexed("") { ind, acc, next -> acc + "    ${ind+1} - ${next.nome} ${next.sobreNome}\n"}
}