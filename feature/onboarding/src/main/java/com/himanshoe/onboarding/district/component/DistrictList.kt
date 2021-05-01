package com.himanshoe.onboarding.district.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.himanshoe.core.component.ListLoadingComponent
import com.himanshoe.onboarding.district.data.response.District
import com.himanshoe.onboarding.district.ui.DistrictViewModel
import java.util.Collections.emptyList

@Composable
fun DistrictList(viewModel: DistrictViewModel, onClick: (Int, String) -> Unit) {

    val states = viewModel.districtResponse.observeAsState()
    val districts = listOf<District>(
        District(0, "Churu"),
        District(2, "Ganganagar"),
        District(3, "Jaipur"),
        District(4, "Udaipur"),
    )
    val loadingState = viewModel.loading.observeAsState()

    if (loadingState.value == true) {
        Box(modifier = Modifier.fillMaxSize()) {
            ListLoadingComponent()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(items = districts, null, {
                DistrictItem(it, onClick)
                Divider()
            })
        }
    }
}