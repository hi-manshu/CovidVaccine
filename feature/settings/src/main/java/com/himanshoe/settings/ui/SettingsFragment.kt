package com.himanshoe.settings.ui

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.core.navigation.event.consume
import com.himanshoe.settings.component.FloatingBanner
import com.himanshoe.settings.component.LabelContent
import com.himanshoe.settings.component.SettingsToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment() {

    private val viewModel by viewModels<SettingsViewModel>()

    override fun setupObserver() {
        viewModel.error.observe(viewLifecycleOwner, {
            it.consume { event ->
                Toast.makeText(requireContext(), event.data, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun init() {
        viewModel.apply {
            init()
            navigator.navigateBy(this@SettingsFragment)
        }
    }

    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    @Composable
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    SettingsToolbar {
                        viewModel.goBack()
                    }
                    FloatingBanner(viewModel, {
                        viewModel.dismissBanner()
                    }, {
                        viewModel.savePinCode(it)
                    })
                }
            }) {
            LabelContent(viewModel, {
                viewModel.gotoStates()
            }, {
                viewModel.showPinCode()
            },{
                viewModel.openLogin()
            })

        }
    }
}