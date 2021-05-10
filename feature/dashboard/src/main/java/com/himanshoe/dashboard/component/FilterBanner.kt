package com.himanshoe.dashboard.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.core.navigation.event.consume
import com.himanshoe.dashboard.ui.DashboardViewModel
import java.util.*

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun FilterBanner(viewModel: DashboardViewModel, onDismiss: () -> Unit, onSave: (String) -> Unit) {

    val dismissState = viewModel.openFilter.observeAsState()

    val dismissValue = remember {
        mutableStateOf(true)
    }

    dismissState.value?.consume {
        dismissValue.value = it.data
    }

    AnimatedVisibility(visible = dismissValue.value) {
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
                    text = "Filter by age",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(12.dp))

                val radioOptions = listOf("18+", "45+", "all")

                val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }

                Row(modifier = Modifier.fillMaxWidth()) {
                    radioOptions.forEach { text ->
                        Row(
                            Modifier

                                .wrapContentWidth()

                                .selectable(

                                    selected = (text == selectedOption),

                                    onClick = { onOptionSelected(text) }
                                )

                                .padding(horizontal = 8.dp)
                        ) {

                            RadioButton(

                                selected = (text == selectedOption),
                                modifier = Modifier,
                                colors = RadioButtonDefaults.colors(
                                    unselectedColor = Color.Gray,
                                    selectedColor = Color.Black
                                ),
                                onClick = {

                                }
                            )

                            Text(
                                style = TextStyle(color = Color.Black),
                                text = text.capitalize(Locale.ROOT),
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))
                Row(modifier = Modifier.fillMaxWidth()) {

                    OutlinedButton(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(end = 4.dp)
                    ) {
                        Text(
                            text = "Dismiss",
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Button(
                        onClick = {
                            onSave(selectedOption)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp),
                        colors =
                        ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                    ) {
                        Text(
                            text = "Save",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }


}
