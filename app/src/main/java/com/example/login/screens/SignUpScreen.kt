package com.example.login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.components.Btn
import com.example.login.components.CheckField
import com.example.login.components.FooterDivider
import com.example.login.components.Header
import com.example.login.components.TxtField

@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header(txt1 = stringResource(id = R.string.header1), txt2 = "Create An Account")
            Spacer(modifier = Modifier.height(15.dp))
            TxtField(label = "First Name", ic = Icons.Default.Face)
            TxtField(label = "Last Name", ic = Icons.Default.Face)
            TxtField(label = "Email", ic = Icons.Default.Email)
            TxtField(label = "Password", ic = Icons.Default.Lock, isPsw = true)
            CheckField()
            Spacer(modifier = Modifier.height(25.dp))
            Btn(value = "Register")
            Spacer(modifier = Modifier.height(45.dp))
            FooterDivider()

        }
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen()
}