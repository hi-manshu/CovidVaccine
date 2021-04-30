package com.himanshoe.onboarding.district.ui

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DistrictFragment : BaseFragment() {

    private val viewModel by viewModels<DistrictViewModel>()

    override fun setupObserver() {

    }

    override fun init() {
        viewModel.apply {
            init()
            navigator.navigateBy(this@DistrictFragment)
        }
    }

    @Composable
    override fun SetupView() {
    }
}