package com.himanshoe.dashboard.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.himanshoe.dashboard.data.response.Center
import com.himanshoe.dashboard.ui.DashboardViewModel
import java.util.*

@Composable
fun LocationList(
    viewModel: DashboardViewModel,
    onMapLocationFetch: (Pair<Double, Double>) -> Unit
) {
    val searchQuery = viewModel.searchQuery.observeAsState()

    val locations = viewModel.vaccineLocationResponse.observeAsState()

    val pinCode = viewModel.searchPinCode.observeAsState()

    val centers = locations.value?.centers ?: emptyList()

    val textState = remember { mutableStateOf(centers) }

    val locationList = getFilteredList(searchQuery.value, pinCode.value, centers)

    textState.value = locationList

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(items = textState.value.sortedBy {
            it.name
        } ?: emptyList(), key = null, {
            LocationItem(it, onMapLocationFetch)
        })
    }
}

fun getFilteredList(query: String?, pinCode: String?, centers: List<Center>): List<Center> {
    if (!pinCode.isNullOrEmpty()) {
        return centers.filter {
            it.pincode.toString().toLowerCase(Locale.ROOT).contains(pinCode)
        }
    } else {
        return if (query != null && centers.isNotEmpty()) {
            val q = query.toLowerCase(Locale.ROOT)
            centers.filter {
                it.name.toLowerCase(Locale.ROOT).contains(q)
                        || it.blockName.toLowerCase(Locale.ROOT).contains(q)
                        || it.stateName.toLowerCase(Locale.ROOT).contains(q)
                        || it.pincode.toString().toLowerCase(Locale.ROOT).contains(q)
                        || it.districtName.toLowerCase(Locale.ROOT).contains(q)
            }
        } else {
            centers
        }
    }
}
