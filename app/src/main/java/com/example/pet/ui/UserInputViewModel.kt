package com.example.pet.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pet.data.UserDataUiEvents
import com.example.pet.data.UserInputState

class UserInputViewModel : ViewModel() {

     var uiState = mutableStateOf(UserInputState())

    private val tag = "UserInputViewModel"

    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.i(tag, "${event.name}: ${uiState.value} ")
            }
            is UserDataUiEvents.AnimalSelected -> {
              uiState.value = uiState.value.copy(
                  animalSelected = event.animal
              )
                Log.i(tag, "${event.animal}: ${uiState.value} ")

            }
        }
    }
}



