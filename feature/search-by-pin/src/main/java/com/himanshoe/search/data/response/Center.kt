package com.himanshoe.search.data.response


import com.google.gson.annotations.SerializedName

data class Center(
    @SerializedName("block_name")
    val blockName: String, // Maval
    @SerializedName("center_id")
    val centerId: Int, // 691499
    @SerializedName("district_name")
    val districtName: String, // Pune
    @SerializedName("fee_type")
    val feeType: String, // Free
    @SerializedName("from")
    val from: String, // 09:00:00
    @SerializedName("lat")
    val lat: Int, // 18
    @SerializedName("long")
    val long: Int, // 73
    @SerializedName("name")
    val name: String, // Takave Khd Sub Center
    @SerializedName("pincode")
    val pincode: Int, // 410401
    @SerializedName("sessions")
    val sessions: List<Session>,
    @SerializedName("state_name")
    val stateName: String, // Maharashtra
    @SerializedName("to")
    val to: String // 18:00:00
)