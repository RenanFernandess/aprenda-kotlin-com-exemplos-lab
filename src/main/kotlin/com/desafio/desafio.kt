import data.Conteudos
import data.models.Formacao
import data.models.Nivel
import data.models.Sexo

fun main(args: Array<String>) {
    val formacao: Formacao = Formacao(
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

    println("Lista de conteudos: ${formacao.listarConteudos()}")
    println("Lista de instcritos: ${formacao.listarInscritos()}")
}
