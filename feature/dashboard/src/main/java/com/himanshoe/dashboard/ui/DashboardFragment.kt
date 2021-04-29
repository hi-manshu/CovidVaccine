package com.himanshoe.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.dashboard.component.SearchAppBar
import com.himanshoe.dashboard.component.Toolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment() {

    private val viewModel by viewModels<DashboardViewModel>()

    override fun setupObserver() {

    }

    override fun init() {
        viewModel.init()
    }

    @Composable
    @ExperimentalComposeUiApi
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    Toolbar()
                    SearchAppBar()
                }
            }) {

        }
    }
}