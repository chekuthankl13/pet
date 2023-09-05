package com.example.pet.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pet.R
import com.example.pet.data.UserDataUiEvents
import com.example.pet.ui.ImgCard
import com.example.pet.ui.TopBar
import com.example.pet.ui.TxtField
import com.example.pet.ui.TxtTile
import com.example.pet.ui.UserInputViewModel
import com.example.pet.ui.WelcomeBtn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),

            ) {
            TopBar("Hi there \uD83D\uDCAB")
            Spacer(modifier = Modifier.height(25.dp))
            TxtTile(txt = "Let's learn about you !", size = 25.sp)
            Spacer(modifier = Modifier.height(20.dp))
            TxtTile(
                txt = "This app will prepare a detail page based on input provided by you !",
                size = 18.sp
            )
            Spacer(modifier = Modifier.size(50.dp))
            TxtField(onTextChanged = {
                userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
            })
            Spacer(modifier = Modifier.size(20.dp))

            TxtTile(txt = "What do you like ?", size = 18.sp)

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ImgCard(
                    img = R.drawable.cat,
                    selected = userInputViewModel.uiState.value.animalSelected == "Cat",
                    onClick = {
                        userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                    })
                ImgCard(
                    img = R.drawable.dog,
                    selected = userInputViewModel.uiState.value.animalSelected == "Dog"
                ) {
                    userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))

                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.End) {
                if (userInputViewModel.uiState.value.nameEntered.isNotEmpty() && userInputViewModel.uiState.value.animalSelected.isNotEmpty())
                    WelcomeBtn {
                        navController.navigate(Routes.WELCOME_SCREEN)
                    }

            }

        }
    }
}

@Preview
@Composable
fun UserInputPreview() {
    UserInputScreen(UserInputViewModel(), rememberNavController())
}