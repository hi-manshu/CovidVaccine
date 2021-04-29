package com.himanshoe.splash.ui

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.core.navigation.event.consume
import com.himanshoe.splash.component.SplashComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment() {

    private val viewModel by viewModels<SplashViewModel>()

    override fun setupObserver() {
        viewModel.navigateToDashboard.observe(viewLifecycleOwner, { navigate ->
            navigate.consume {

            }
        })
    }

    override fun init() {
        viewModel.apply {
            navigator.navigateBy(this@SplashFragment)
            init()
        }
    }

    @Composable
    override fun SetupView() {
        SplashComponent()
    }
}