package com.himanshoe.onboarding.district.data.response


import com.google.gson.annotations.SerializedName

data class District(
    @SerializedName("district_id")
    val districtId: Int = 0, // 270
    @SerializedName("district_name")
    val districtName: String = "" // Bagalkot
)