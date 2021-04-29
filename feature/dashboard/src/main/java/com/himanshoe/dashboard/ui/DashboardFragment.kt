package com.himanshoe.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.dashboard.component.DisplayCard
import com.himanshoe.dashboard.component.SearchAppBar
import com.himanshoe.dashboard.component.Toolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment() {

    override fun setupObserver() {

    }

    override fun init() {
    }

    @Composable
    override fun SetupView() {
        Column {
            Toolbar()
            SearchAppBar()
        }
    }
}