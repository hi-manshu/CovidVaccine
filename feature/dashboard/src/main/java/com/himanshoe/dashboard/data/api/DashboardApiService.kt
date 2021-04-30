package com.himanshoe.dashboard.data.api

import com.himanshoe.dashboard.data.response.VaccineLocatorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DashboardApiService {

    @GET("/api/v2/appointment/sessions/public/calendarByDistrict")
    suspend fun getLocations(
        @Query("district_id") districtId: String,
        @Query("date") date: String,
    ): Response<VaccineLocatorResponse>
}