package com.himanshoe.splash.util

import androidx.navigation.navOptions
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.fadeAnimation
import com.himanshoe.splash.R

private fun navigateToDashboard(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://dashboard",
        navOptions {
            popUpTo(R.id.splashFragment2) { inclusive = true }
            fadeAnimation()
        }
    )
}

fun deepLinkToDashboard() = navigateToDashboard()

private fun navigateToState(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://state",
        navOptions {
            popUpTo(R.id.splashFragment2) { inclusive = true }
            fadeAnimation()
        }
    )
}

fun deepLinkToState() = navigateToState()