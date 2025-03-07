package org.scesi.cappuchino.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.scesi.domain.models.Career
import org.scesi.usescases.usecases.GetCareerUseCase

@KoinViewModel
class HomeViewModel(
    private val getCareerUseCase: GetCareerUseCase
): ViewModel() {
    private val _careers = MutableStateFlow<List<Career>>(emptyList())
    val careers: StateFlow<List<Career>> = _careers.asStateFlow()

    init {
        fetchCareers()
    }
    private fun fetchCareers() {
        viewModelScope.launch {
            val result = getCareerUseCase()
            _careers.value = result
        }
    }

}