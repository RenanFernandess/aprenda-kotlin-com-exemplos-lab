package com.desafio.data.models

data class User (
    val name: String,
    val lastName: String,
    val age: Int,
    val sex: Sex?
)