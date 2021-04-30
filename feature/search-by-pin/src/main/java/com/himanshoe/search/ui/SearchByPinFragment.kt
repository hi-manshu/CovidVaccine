package com.himanshoe.search.ui

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByPinFragment : BaseFragment() {

    private val viewModel by viewModels<SearchByPinViewModel>()

    override fun setupObserver() {

    }

    override fun init() {

    }

    @Composable
    override fun SetupView() {
    }
}