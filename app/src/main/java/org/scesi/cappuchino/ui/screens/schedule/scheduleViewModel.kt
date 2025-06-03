package org.scesi.cappuchino.ui.screens.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.scesi.domain.models.CapResult
import org.scesi.usescases.usecases.GetSubjectsUseCase

@KoinViewModel
class ScheduleViewModel(
    private val getSubjectsUseCase: GetSubjectsUseCase
) : ViewModel() {

    private val _subjectState = MutableStateFlow("Cargando...")
    val subjectState: StateFlow<String> = _subjectState

    fun loadSubjects(code: String, path: String) {
        viewModelScope.launch {
            when (val result = getSubjectsUseCase(code, path)) {
                is CapResult.Success -> {
                    val levels = result.data.levels
                    val formattedLevels = levels.joinToString("\n") { level ->
                        "Nivel: ${level.code}\n" +
                                level.subjects.joinToString("\n") { subject ->
                                    "  Materia: ${subject.name}\n" +
                                            subject.groups.joinToString("\n") { group ->
                                                "    Grupo: ${group.code}\n" +
                                                        group.schedule.joinToString("\n") { schedule ->
                                                            "      Día: ${schedule.day}, Inicio: ${schedule.start}, Fin: ${schedule.end}, Aula: ${schedule.room}"
                                                        }
                                            }
                                }
                    }
                    _subjectState.value = formattedLevels
                }
                is CapResult.Error -> {
                    _subjectState.value = "Error al cargar niveles"
                }
            }
        }
    }
}