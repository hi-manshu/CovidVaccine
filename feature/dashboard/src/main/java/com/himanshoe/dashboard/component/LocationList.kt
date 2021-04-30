package com.himanshoe.dashboard.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.himanshoe.dashboard.ui.DashboardViewModel

@Composable
fun LocationList(viewModel: DashboardViewModel) {

    val locations = viewModel.vaccineLocationResponse.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(items = locations.value?.centers?.sortedBy {
            it.name
        } ?: emptyList(), key = null, {
            LocationItem(it)
        })
    }

}