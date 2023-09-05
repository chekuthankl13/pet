package com.example.pet.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pet.R

@Composable
fun TopBar(txt: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = txt, fontWeight = FontWeight.Medium, fontSize = 25.sp)
        Image(
            painter = painterResource(id = R.drawable.dove),
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Hi there")
}


@Composable
fun TxtTile(txt: String, size: TextUnit, clr: Color = Color.Black) {
    Text(text = txt, fontSize = size, color = clr, fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TxtTilePreview() {
    TxtTile(txt = "hloo guyss", size = 30.sp)
}


@ExperimentalMaterial3Api
@Composable
fun TxtField(
    onTextChanged: (name: String) -> Unit,
) {
    var valu by remember {
        mutableStateOf("")
    }

    val focus = LocalFocusManager.current
    OutlinedTextField(value = valu, onValueChange = {
        onTextChanged(it)
        valu = it
    },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
//        keyboardActions = KeyboardActions(){
//                   focus.clearFocus()
//        },
        placeholder = {
            Text(text = "Enter your name")
        }

    )
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun TxtFieldPreview() {
//    TxtField()
}


@Composable
fun ImgCard(img: Int, selected: Boolean, onClick: (name: String) -> Unit) {
    val focus = LocalFocusManager.current
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier

            .padding(20.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        var name = if (img == R.drawable.cat) "Cat" else "Dog"
                        onClick(name)
                        focus.clearFocus()
                    },
                painter = painterResource(id = img), contentDescription = "cat",

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImgCardPreview() {
    ImgCard(R.drawable.cat, selected = true, { "cat" })
}


@Composable
fun WelcomeBtn(onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
        onClick = { onClick() }) {
        TxtTile(txt = "Welcome Board !!", size = 20.sp, clr = Color.White)
    }
}

@Preview
@Composable
fun WelcomeBtnPreview() {
    WelcomeBtn() {}
}