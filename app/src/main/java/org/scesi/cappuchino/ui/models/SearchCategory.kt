package org.scesi.cappuchino.ui.models

sealed class SearchCategory(
    var searchCriteria: String
) {
    data class Subject(
        val name: String
    ) : SearchCategory(name)

    companion object {
        val subjectsExample = listOf(
            Subject("Licenciatura en Ing en Sistemas"),
            Subject("Licenciatura en Ing en Informática"),
            Subject("Matematica"),
            Subject("Fisica")
        )
    }
}
