package com.example.calinac.ui

import androidx.lifecycle.ViewModel
import com.example.calinac.data.AnimalState
import com.example.calinac.data.ProfilState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnimalViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AnimalState())
    val uiState: StateFlow<AnimalState> = _uiState.asStateFlow()

    fun updateInfos(
        name: String,
        weight: Int,
        age: Int,
        gender: String,
        breed: String
    ) {
        _uiState.value = AnimalState(name, weight, age, gender, breed)
    }

}