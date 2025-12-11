package com.desafio.data.database

import com.desafio.Usuario
import com.desafio.data.models.Formacao
import com.desafio.data.models.Nivel
import com.desafio.data.models.Sexo

object Formacoes {
    private val _data: MutableList<Formacao> = mutableListOf()
    val data: List<Formacao> get() = _data

    fun iniciar() {
        val formacao = Formacao(
            nome = "Desenvolvimento Web",
            nivel = Nivel.INTERMEDIARIO,
            conteudos = Conteudos.desenvolvimentoWeb
        )

        formacao.matricularVarios(
            Usuario(
                "João",
                "Paulo",
                28,
                Sexo.MASCULINO
            ),
            Usuario(
                "Maria",
                "Luisa",
                25,
                Sexo.FEMININO
            )
        )

        _data.add(formacao)
    }

}