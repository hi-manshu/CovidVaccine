package com.himanshoe.onboarding.state.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.himanshoe.core.component.ListLoadingComponent
import com.himanshoe.onboarding.state.data.response.State
import com.himanshoe.onboarding.state.ui.StateViewModel
import java.util.Collections.emptyList

@Composable
fun StateList(viewModel: StateViewModel, onClick: (Int, String) -> Unit) {

    val states = viewModel.stateReponse.observeAsState()
    val stateList = listOf<State>(State(0, "Rajasthan"), State(1, "Delhi"), State(2, "Punjab"))
    val loadingState = viewModel.loading.observeAsState()

    if (loadingState.value == true) {
        Box(modifier = Modifier.fillMaxSize()) {
            ListLoadingComponent()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(items = stateList, null, {
                StateItem(it, onClick)
                Divider()
            })
        }
    }
}