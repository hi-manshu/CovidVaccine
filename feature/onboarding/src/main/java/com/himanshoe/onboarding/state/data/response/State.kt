package com.himanshoe.onboarding.state.data.response


import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("state_id")
    val stateId: Int = 0, // 1
    @SerializedName("state_name")
    val stateName: String = "" // Andaman and Nicobar Islands
)