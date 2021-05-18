package com.himanshoe.settings.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.core.navigation.event.consume
import com.himanshoe.settings.ui.SettingsViewModel

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun DownloadCertificate(viewModel: SettingsViewModel, onSave: (String) -> Unit) {

    AnimatedVisibility(visible = true) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp),
            elevation = 2.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Please enter the Reference ID to download the certificate",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(12.dp))

                val textState = remember { mutableStateOf("") }

                val keyboardController = LocalSoftwareKeyboardController.current

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = textState.value,
                    placeholder = {
                        Text(text = "Reference-id")
                    },
                    onValueChange = { textState.value = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Sharp.Create,
                            tint = colorResource(id = R.color.ripple_material_light),
                            contentDescription = "search"
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
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color.LightGray,
                        cursorColor = MaterialTheme.colors.primary
                    )
                )
                Spacer(Modifier.height(12.dp))
                Row(modifier = Modifier.fillMaxWidth()) {

                    Button(
                        onClick = {
                            onSave(textState.value)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                    ) {
                        Text(
                            text = "Download",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
