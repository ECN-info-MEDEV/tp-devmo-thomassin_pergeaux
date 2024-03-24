package com.example.calinac.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.calinac.data.ProfilState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfilState())
    val uiState: StateFlow<ProfilState> = _uiState.asStateFlow()

    fun updateCoordonnees(
        username: String,
        email: String,
        name: String,
        surname: String,
        phone: String
    ){
        Log.d("Update Data","Update Coordonnées" + name)
        _uiState.value = ProfilState(
            username = username,
            email = email,
            name = name,
            surName = surname,
            phoneNumber = phone
        )
    }

}