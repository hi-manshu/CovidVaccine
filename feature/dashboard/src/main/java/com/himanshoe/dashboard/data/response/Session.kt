package com.himanshoe.dashboard.data.response

import com.google.gson.annotations.SerializedName

data class Session(
    @SerializedName("available_capacity")
    val availableCapacity: Double = 0.0, // 37.5
    @SerializedName("date")
    val date: String = "", // 31-03-2021
    @SerializedName("min_age_limit")
    val minAgeLimit: Int = 0, // 45
    @SerializedName("session_id")
    val sessionId: String = "", // d558152d-3aa9-4e41-8532-fe64649adbc5
    @SerializedName("slots")
    val slots: List<String> = emptyList(),
    @SerializedName("vaccine")
    val vaccine: String = ""
)