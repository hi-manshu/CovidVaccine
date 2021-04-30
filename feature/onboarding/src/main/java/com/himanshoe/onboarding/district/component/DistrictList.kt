package com.himanshoe.onboarding.district.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.himanshoe.onboarding.district.ui.DistrictViewModel
import java.util.Collections.emptyList

@Composable
fun DistrictList(viewModel: DistrictViewModel, onClick: (Int) -> Unit) {

    val states = viewModel.districtResponse.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(items = states.value?.districts ?: emptyList(), null, {
            DistrictItem(it, onClick)
            Divider()
        })
    }
}