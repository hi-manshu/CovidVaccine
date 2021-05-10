package com.himanshoe.dashboard.ui

import LocationList
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.himanshoe.core.base.BaseFragment
import com.himanshoe.core.navigation.event.consume
import com.himanshoe.dashboard.component.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview


@AndroidEntryPoint
class DashboardFragment : BaseFragment() {

    private val viewModel by viewModels<DashboardViewModel>()

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
            navigator.navigateBy(this@DashboardFragment)
        }
    }

    @ExperimentalAnimationApi
    @FlowPreview
    @Composable
    @ExperimentalComposeUiApi
    override fun SetupView() {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Column {
                    Toolbar(onSettingsClicked = {
                        viewModel.navigateToSettings()
                    })
                    SearchAppBar({
                        viewModel.onSearch(it)
                    }, {
                        viewModel.openFilter()
                    })
                    FloatingBanner(viewModel, {
                        viewModel.dismissBanner()
                    }, {
                        viewModel.savePinCode(it)
                    })
                    FilterBanner(viewModel, {
                        viewModel.dismissFilterBanner()
                    }, {
                        viewModel.saveAgeFilter(it)
                        viewModel.dismissFilterBanner()
                    })
                }
            }, floatingActionButton = {
                InstantSearch {
                    viewModel.navigateToSearch()
                }
            }) {
            Box(modifier = Modifier.fillMaxSize()) {
                LocationList(viewModel) {
                    openMaps(it)
                }
            }
        }
    }

    private fun openMaps(latLong: Pair<Double, Double>) {
        val address = latLong.first.toString() + "," + latLong.second.toString()
        val url = "https://www.google.com/maps/search/?api=1&query=$address"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}