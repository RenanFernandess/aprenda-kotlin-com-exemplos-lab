package com.desafio.data.models

data class Course(
    val title: String,
    val levelOfEducation: LevelOfEducation,
    val contents: List<EducationalContent>
) {
    private val _enrolled: MutableList<User> = mutableListOf()
    val enrolled: List<User> get() = _enrolled

    fun enroll(user: User) = _enrolled.add(user)

    fun enrollAll(vararg users: User): Boolean {
        return _enrolled.addAll(users)
    }

    fun listContents (): String = contents
        .foldIndexed("") { ind, acc, next -> acc + "    ${ind+1} - ${next.title}: ${next.duration}min\n"}

    fun listEnrolled (): String = enrolled
        .foldIndexed("") { ind, acc, next -> acc + "    ${ind+1} - ${next.name} ${next.lastName}\n"}
}