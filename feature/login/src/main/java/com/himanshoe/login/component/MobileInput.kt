package com.himanshoe.login.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.himanshoe.login.LoginViewModel

@ExperimentalComposeUiApi
@Composable
fun MobileInput(
    viewModel: LoginViewModel,
    onQueryChange: (String) -> Unit,
    onOtpChange: (String, String) -> Unit,
) {
    val loginResponse = viewModel.loginResponse.observeAsState()
    val txnId: String? = loginResponse.value?.txnId

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = MaterialTheme.colors.secondary,
        elevation = 8.dp,
    ) {
        val otpState = remember { mutableStateOf("") }

        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                val textState = remember { mutableStateOf("") }
                if (textState.value.length == 10) {
                    onQueryChange(textState.value)
                }
                val keyboardController = LocalSoftwareKeyboardController.current

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    value = textState.value,
                    placeholder = {
                        Text(text = "Please enter you mobile number")
                    },
                    onValueChange = { textState.value = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Sharp.Phone,
                            tint = colorResource(id = R.color.ripple_material_light),
                            contentDescription = "Phone"
                        )
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.body1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        keyboardController?.hideSoftwareKeyboard()
                    }),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colors.primary
                    )
                )
            }

            Divider()
            if (!txnId.isNullOrEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    val keyboardController = LocalSoftwareKeyboardController.current

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        value = otpState.value,
                        placeholder = {
                            Text(text = "Please enter the otp")
                        },
                        onValueChange = { otpState.value = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Sharp.Lock,
                                tint = colorResource(id = R.color.ripple_material_light),
                                contentDescription = "otp"
                            )
                        },
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body1,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hideSoftwareKeyboard()
                        }),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colors.background,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = MaterialTheme.colors.primary
                        )
                    )
                }
                Divider()
                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    if (otpState.value.length == 6) {
                        onOtpChange(otpState.value, txnId)
                    }
                }) {
                    Text(text = "Login")
                }
            }
        }
    }
}