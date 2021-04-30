package com.himanshoe.core.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.LottieAnimationState
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.himanshoe.core.R

@Composable
fun ListLoadingComponent() {
    val animationSpec: LottieAnimationSpec.RawRes =
        remember { LottieAnimationSpec.RawRes(R.raw.list_loading) }
    val animationState: LottieAnimationState =
        rememberLottieAnimationState(autoPlay = true, repeatCount = Integer.MAX_VALUE)

    LottieAnimation(
        animationSpec,
        modifier = Modifier.fillMaxSize(),
        animationState = animationState
    )
}