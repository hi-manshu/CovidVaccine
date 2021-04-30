package com.himanshoe.search.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.search.component.SearchComponent
import com.himanshoe.search.component.SearchToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByPinFragment : BaseFragment() {

    private val viewModel by viewModels<SearchByPinViewModel>()

    override fun setupObserver() {

    }

    override fun init() {

    }

    @ExperimentalComposeUiApi
    @Composable
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    SearchToolbar()
                    SearchComponent {

                    }
                }
            }) {

        }
    }
}