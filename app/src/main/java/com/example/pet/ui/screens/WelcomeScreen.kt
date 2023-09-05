package com.example.pet.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pet.ui.TopBar
import com.example.pet.ui.TxtTile
import com.example.pet.ui.UserInputViewModel

@Composable
fun WelcomeScreen(navController : NavHostController,userInputViewModel : UserInputViewModel) {
  Surface (modifier = Modifier.fillMaxSize()) {
   Column (
       modifier = Modifier
           .fillMaxSize()
           .padding(8.dp)
           .padding(15.dp)
   ) {
       TopBar("Welcome Board ✌️")
       Spacer(modifier = Modifier.size(20.dp))
       TxtTile(txt ="Thank you for sharing your data !!" , size =18.sp )
       Spacer(modifier = Modifier.size(20.dp))
      TxtTile(txt = "You are a ${userInputViewModel.uiState.value.animalSelected} lover \uD83D\uDC93", size =20.sp )
   }
  }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController(), UserInputViewModel())
}