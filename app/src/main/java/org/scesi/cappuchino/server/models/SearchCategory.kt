package org.scesi.cappuchino.server.models

import kotlinx.serialization.Serializable

@Serializable
sealed class SearchCategory {
    abstract val searchCriteria: String

    @Serializable
    data class RemoteCareer(
        val name: String
    ) : SearchCategory() {
        override val searchCriteria: String
            get() = name
    }
}
val mockedSubjects = listOf(
    SearchCategory.RemoteCareer("Licenciatura en Ing en Sistemas"),
    SearchCategory.RemoteCareer("Licenciatura en Ing en Informática"),
    SearchCategory.RemoteCareer("Matematica"),
    SearchCategory.RemoteCareer("Fisica")
)