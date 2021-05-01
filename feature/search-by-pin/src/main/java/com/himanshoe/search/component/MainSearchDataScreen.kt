package com.himanshoe.search.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.himanshoe.search.data.response.Center
import com.himanshoe.search.ui.SearchByPinViewModel
import java.util.*
import java.util.Collections.emptyList

@Composable
fun MainSearchDataScreen(viewModel: SearchByPinViewModel) {

    val searchQueryState = viewModel.searchQuery.observeAsState()

    val locationState = viewModel.locationResponse.observeAsState()

    val pinCode = searchQueryState.value

    if (pinCode.toString().length == 6) {
        viewModel.fetchLocation(pinCode.toString())

        val location = locationState.value

        val centers = location?.centers ?: emptyList()

        val textState = remember { mutableStateOf(centers) }

        val locationList = getFilteredList("", centers ?: emptyList())

        textState.value = locationList

        if (location != null) {
            LoadTheLocationList(textState)
        } else {
            EmptySearch()
        }
    } else {
        EmptySearch()
    }
}

@Composable
fun LoadTheLocationList(location: MutableState<List<Center>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(items = location.value.sortedBy {
            it.name
        } ?: emptyList(), key = null, {
            LocationItem(it)
        })
    }
}

fun getFilteredList(query: String?, centers: List<Center>): List<Center> {
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

