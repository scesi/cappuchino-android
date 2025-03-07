package org.scesi.domain.models

sealed class SearchCategory {
    abstract val searchCriteria: String

    data class Career(
        val name: String
    ) : SearchCategory() {
        override val searchCriteria: String
            get() = name
    }
}
val mockedSubjects = listOf(
    SearchCategory.Career("Licenciatura en Ing en Sistemas"),
    SearchCategory.Career("Licenciatura en Ing en Informática"),
    SearchCategory.Career("Matematica"),
    SearchCategory.Career("Fisica")
)