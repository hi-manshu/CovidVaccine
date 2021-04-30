package com.himanshoe.onboarding.district.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.onboarding.district.component.DistrictList
import com.himanshoe.onboarding.district.component.DistrictToolbar
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
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    DistrictToolbar()
                }
            }) {
            Box(modifier = Modifier.fillMaxSize()) {
                DistrictList(viewModel) {
                    viewModel.setDistrict(it)
                }
            }
        }
    }
}