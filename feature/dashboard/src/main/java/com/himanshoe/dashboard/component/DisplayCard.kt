package com.himanshoe.dashboard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshoe.core.design.BaseShape
import com.himanshoe.core.design.medium

@Composable
fun DisplayCard() {
    Card(
        shape = BaseShape.large, modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .padding(medium)
    ) {

    }
}