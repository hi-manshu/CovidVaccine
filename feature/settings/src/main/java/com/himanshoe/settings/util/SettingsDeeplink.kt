package com.himanshoe.settings.util

import androidx.navigation.navOptions
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.fadeAnimation

private fun navigateToState(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://state",
        navOptions {
            fadeAnimation()
        }
    )
}

fun deepLinkToState() = navigateToState()