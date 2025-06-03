package org.scesi.domain.models

sealed class SearchCategory {
    abstract val searchCriteria: String

    data class Career(
        val code: Int,
        val name: String,
        val path: String
    ) : SearchCategory() {
        override val searchCriteria: String
            get() = name
    }
    data class Subject(
        val madeIn: String,
        val semester: String,
        val support: String,
        val path: String,
        val code: Int,
        val name: String,
        val url: String,
        val updatedAt: String,
        val levels: List<Level>
    )

    data class Level(
        val code: String,
        val subjects: List<DomainSubject>
    )

    data class DomainSubject(
        val code: Int,
        val name: String,
        val groups: List<Group>
    )

    data class Group(
        val code: String,
        val schedule: List<Schedule>,
        val teacher: String
    )

    data class Schedule(
        val day: String,
        val start: String,
        val end: String,
        val duration: String,
        val room: String,
        val teacher: String,
        val isClass: Boolean
    )
}
val mockedSubjects = listOf(
    SearchCategory.Career(1, "Licenciatura en Ing en Sistemas", "2025-01"),
    SearchCategory.Career(2, "Licenciatura en Ing Informatica", "2025-01"),
    SearchCategory.Career(3, "Licenciatura en Ing Civil", "2025-01"),
    SearchCategory.Career(4, "Licenciatura en Ing Matematica", "2025-01"),
    SearchCategory.Career(5, "Licenciatura en Ing Quimica", "2025-01")
)