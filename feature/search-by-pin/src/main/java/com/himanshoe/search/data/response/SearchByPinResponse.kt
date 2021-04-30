package com.himanshoe.search.data.response


import com.google.gson.annotations.SerializedName

data class SearchByPinResponse(
        @SerializedName("centers")
        val centers: List<Center>
)