package com.himanshoe.onboarding.state.data.response

import com.google.gson.annotations.SerializedName
import java.util.Collections.emptyList

data class StateResponse(
    @SerializedName("states")
    val states: List<State> = emptyList(),
    @SerializedName("ttl")
    val ttl: Int = 0// 24
)