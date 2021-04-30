package com.himanshoe.onboarding.state.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.onboarding.state.component.StateList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StateFragment : BaseFragment() {

    private val viewModel by viewModels<StateViewModel>()

    override fun setupObserver() {

    }

    override fun init() {
        viewModel.init()
    }

    @Composable
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {

                }
            }) {
            Box(modifier = Modifier.fillMaxSize()) {
                StateList(viewModel)
            }
        }
    }
}