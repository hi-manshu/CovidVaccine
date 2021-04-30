package com.himanshoe.onboarding.state.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.himanshoe.onboarding.state.ui.StateViewModel

@Composable
fun StateList(viewModel: StateViewModel) {

    val states = viewModel.stateReponse.observeAsState()
    Log.d("Assasasa", states.value.toString())
}