package com.himanshoe.dashboard.data.response

import com.google.gson.annotations.SerializedName

data class VaccineFee(
    @SerializedName("fee")
    val fee: String = "", // 0
    @SerializedName("vaccine")
    val vaccine: String = ""// COVAXIN
)