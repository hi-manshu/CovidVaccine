package com.himanshoe.splash.util

import androidx.navigation.navOptions
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.fadeAnimation

private fun navigateToDashboard(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://dashboard",
        navOptions {
            fadeAnimation()
        }
    )
}

fun deepLinkToDashboard() = navigateToDashboard()

private fun navigateToState(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://state",
        navOptions {
            fadeAnimation()
        }
    )
}

fun deepLinkToState() = navigateToState()