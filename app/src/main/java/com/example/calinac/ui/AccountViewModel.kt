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
        _uiState.value = ProfilState(
            username = username,
            email = email,
            name = name,
            surName = surname,
            phoneNumber = phone,
            rib =  _uiState.value.rib,
            bank = _uiState.value.bank


        )
    }

    fun updateBanque(
        rib: String,
        banque: String,
    ){
        _uiState.value = ProfilState(
            username = _uiState.value.username,
            email = _uiState.value.email,
            name = _uiState.value.name,
            surName = _uiState.value.surName,
            phoneNumber = _uiState.value.phoneNumber,
            rib = rib,
            bank = banque,
        )
    }

}