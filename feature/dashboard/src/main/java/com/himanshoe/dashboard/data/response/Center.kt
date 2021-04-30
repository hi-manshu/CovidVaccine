package com.himanshoe.dashboard.data.response

import com.google.gson.annotations.SerializedName

data class Center(
    @SerializedName("block_name")
    val blockName: String = "", // Charingia BPHC
    @SerializedName("center_id")
    val centerId: Int = 0, // 70593
    @SerializedName("district_name")
    val districtName: String = "", // Golaghat
    @SerializedName("fee_type")
    val feeType: String = "", // Free
    @SerializedName("from")
    val from: String = "", // 09:00:00
    @SerializedName("lat")
    val lat: Double = 0.0, // 26.612762
    @SerializedName("long")
    val long: Double = 0.0, // 93.825935
    @SerializedName("name")
    val name: String = "", // Sumonigaon MPHC
    @SerializedName("pincode")
    val pincode: Int = 0, // 785626
    @SerializedName("sessions")
    val sessions: List<Session> = emptyList(),
    @SerializedName("state_name")
    val stateName: String = "", // Assam
    @SerializedName("to")
    val to: String = "", // 17:00:00
    @SerializedName("vaccine_fees")
    val vaccineFees: List<VaccineFee> = emptyList()
)