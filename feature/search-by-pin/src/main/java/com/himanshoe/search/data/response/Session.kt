package com.himanshoe.search.data.response


import com.google.gson.annotations.SerializedName

data class Session(
    @SerializedName("available_capacity")
    val availableCapacity: Int, // 47
    @SerializedName("date")
    val date: String, // 01-05-2021
    @SerializedName("min_age_limit")
    val minAgeLimit: Int, // 45
    @SerializedName("session_id")
    val sessionId: String, // d2e8419d-c182-40da-aeec-c14c2f771e3c
    @SerializedName("slots")
    val slots: List<String>,
    @SerializedName("vaccine")
    val vaccine: String
)