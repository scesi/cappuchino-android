package org.scesi.cappuchino.ui.models

sealed class SearchCategory(
    var searchCriteria: String
) {
    data class Subject(
        val name: String
    ) : SearchCategory(name)
}

val mockedSubjects = listOf(
    SearchCategory.Subject("Licenciatura en Ing en Sistemas"),
    SearchCategory.Subject("Licenciatura en Ing en Informática"),
    SearchCategory.Subject("Matematica"),
    SearchCategory.Subject("Fisica")
)