package com.himanshoe.dashboard.data.response

import com.google.gson.annotations.SerializedName

data class VaccineLocatorResponse(
    @SerializedName("centers")
    val centers: List<Center> = emptyList()
)