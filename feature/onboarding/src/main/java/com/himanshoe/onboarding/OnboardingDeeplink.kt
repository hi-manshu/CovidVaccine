package com.himanshoe.onboarding

import androidx.navigation.navOptions
import com.himanshoe.core.navigation.NavigateTo
import com.himanshoe.core.navigation.fadeAnimation

private fun navigateToDistrict(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://district",
        navOptions {
            fadeAnimation()
        }
    )
}

fun deeplinkToDistrict() = navigateToDistrict()

private fun navigateToDashboard(): NavigateTo.DeepLink {

    return NavigateTo.DeepLink(
        "covid://dashboard",
        navOptions {
            fadeAnimation()
        }
    )
}

fun deepLinkToDashboard() = navigateToDashboard()