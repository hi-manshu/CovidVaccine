package com.himanshoe.search.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.LottieAnimationState
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.himanshoe.search.R

@Composable
fun EmptySearch() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Loader()
    }
}

@Composable
fun Loader() {
    val animationSpec: LottieAnimationSpec.RawRes =
        remember { LottieAnimationSpec.RawRes(R.raw.loading) }
    val animationState: LottieAnimationState =
        rememberLottieAnimationState(autoPlay = true, repeatCount = Integer.MAX_VALUE)

    LottieAnimation(
        animationSpec,
        modifier = Modifier.size(300.dp),
        animationState = animationState
    )
}