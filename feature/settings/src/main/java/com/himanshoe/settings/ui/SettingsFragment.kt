package com.himanshoe.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.settings.component.LabelContent
import com.himanshoe.settings.component.SettingsToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment() {

    private val viewModel by viewModels<SettingsViewModel>()

    override fun setupObserver() {

    }

    override fun init() {
        viewModel.apply {
            init()
            navigator.navigateBy(this@SettingsFragment)
        }
    }

    @Composable
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    SettingsToolbar {
                        viewModel.goBack()
                    }
                }
            }) {
            LabelContent(viewModel) {
                viewModel.gotoStates()
            }
        }
    }
}