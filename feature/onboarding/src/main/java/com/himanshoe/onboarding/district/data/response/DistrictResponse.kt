package com.himanshoe.onboarding.district.data.response


import com.google.gson.annotations.SerializedName

data class DistrictResponse(
    @SerializedName("districts")
    val districts: List<District> = emptyList(),
    @SerializedName("ttl")
    val ttl: Int = 0// 24
)