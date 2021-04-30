package com.himanshoe.search.data.api

import com.himanshoe.search.data.response.SearchByPinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchByPinApiService {

    @GET("/api/v2/appointment/sessions/public/calendarByPin")
    suspend fun getCenterByPin(
        @Query("pincode") pincode: String,
        @Query("date") date: String,
    ): Response<SearchByPinResponse>
}