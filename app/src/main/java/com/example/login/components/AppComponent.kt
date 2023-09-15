package com.example.login.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R


@Composable
fun Header(txt1: String, txt2: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = txt1, fontSize = 13.sp, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = txt2, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(5.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header(txt1 = "Hey there,", txt2 = "Create An Account")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TxtField(label: String, ic: ImageVector, isPsw: Boolean = false) {
    var txtValue by remember {
        mutableStateOf("")
    }


    var pswVisble by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(

        value = txtValue, onValueChange = {
            txtValue = it
        },
        label = {
            Text(
                text = label,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Light
            )

        },
        trailingIcon = {
            if (isPsw) {
                if (pswVisble)
                    Icon(
                        painter = painterResource(id = R.drawable.lock_open),
                        contentDescription = "",
                        modifier = Modifier.clickable { pswVisble = false })
                else
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "",
                        modifier = Modifier.clickable { pswVisble = true })

            } else {

            }
        },
        leadingIcon = {
            if (isPsw)
                Icon(painter = painterResource(id = R.drawable.psw), contentDescription = "")
            else
                Icon(
                    imageVector = ic,
                    contentDescription = "",
                    tint = Color.Gray
                )
        },
        maxLines = 1,
        shape = RoundedCornerShape(20.dp),
        keyboardOptions = if (isPsw) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        visualTransformation = if (isPsw) {
            if (pswVisble) VisualTransformation.None else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TxtFieldPreview() {
    TxtField(label = "name", ic = Icons.Default.Settings)
}



@Composable
fun Btn(value: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(colors = listOf(Color.Blue, Color.Cyan)),
                    shape = RoundedCornerShape(50.dp)
                ),


            ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}


@Composable
fun FooterDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = Color.Gray, thickness = 1.dp
        )
        Text(text = "or", fontSize = 18.sp, modifier = Modifier.padding(8.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = Color.Gray, thickness = 1.dp
        )


    }
}

@Composable
fun CheckField() {

    var checkVal by remember {
        mutableStateOf(false)
    }
    val terms = " Terms of use"
    val privacy = "Privacy policy"

    val annotatedString = buildAnnotatedString {
        append("By continuing you accept our ")
        withStyle(style = SpanStyle(color = Color.Blue)) {
            pushStringAnnotation(tag = privacy, annotation = privacy)
            append(privacy)
        }
        append(" and ")
        withStyle(style = SpanStyle(color = Color.Blue)) {
            pushStringAnnotation(tag = terms, annotation = terms)
            append(terms)

        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkVal, onCheckedChange = {
            checkVal = it
        })
        ClickableText(text = annotatedString, onClick = {
            annotatedString.getStringAnnotations(it, it).firstOrNull()
                ?.let { span -> Log.i("KLM", "clicked on ${span.item}") }
        })
    }


}