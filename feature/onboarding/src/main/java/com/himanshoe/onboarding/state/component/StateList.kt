package com.himanshoe.onboarding.state.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.himanshoe.onboarding.state.ui.StateViewModel
import java.util.Collections.emptyList

@Composable
fun StateList(viewModel: StateViewModel) {

    val states = viewModel.stateReponse.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(items = states.value?.states ?: emptyList(), null, {
            StateItem(it)
            Divider()
        })
    }
}