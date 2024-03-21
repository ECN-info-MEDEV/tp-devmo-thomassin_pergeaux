package com.example.calinac.ui

import androidx.lifecycle.ViewModel
import com.example.calinac.data.ProfilState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfilState())
    val uiState: StateFlow<ProfilState> = _uiState.asStateFlow()

}