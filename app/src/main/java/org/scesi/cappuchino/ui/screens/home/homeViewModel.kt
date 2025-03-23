package org.scesi.cappuchino.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory
import org.scesi.usescases.usecases.GetCareerUseCase

@KoinViewModel
class HomeViewModel(
    private val getCareerUseCase: GetCareerUseCase
): ViewModel() {
    private val _dataState = MutableStateFlow(DataState())
    val dataState = _dataState.asStateFlow()

    init {
        fetchCareers()
    }
    private fun fetchCareers() {
        viewModelScope.launch {
            updateIsLoading(true)
            when (val result = getCareerUseCase.invoke()) {
                is CapResult.Error -> {
                    when (result.error) {
                        is CapError.Connectivity ->{
                            _dataState.update { it.copy(error = result.error, isLoading = false) }
                            Log.d("HomeViewModel", result.error.toString())
                        }

                        is CapError.Server -> Log.d("HomeViewModel", result.error.toString())
                        is CapError.Unknown ->  Log.d("HomeViewModel", result.error.toString())
                        is CapError.NotFound -> Log.d("HomeViewModel", result.error.toString())
                    }
                }
                is CapResult.Success -> updateList(result.data)
            }

        }
    }

    private fun updateIsLoading(value: Boolean) {
        _dataState.update { it.copy(isLoading = value) }
    }
    private fun updateList(careers: List<SearchCategory.Career>) {
        _dataState.update { it.copy(careers = careers) }
    }
    fun clearError() {
        _dataState.update { it.copy(error = null) }
    }


    data class DataState(
        val careers: List<SearchCategory.Career> = emptyList(),
        val isLoading: Boolean = true,
        val error: CapError? = null
    )
}