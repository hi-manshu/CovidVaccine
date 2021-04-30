package com.himanshoe.onboarding.district.data.api

import com.himanshoe.onboarding.district.data.response.DistrictResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
interface DistrictApiService {

    @GET("/api/v2/admin/location/districts/{state_id}")
    suspend fun getDistricts(@Path("state_id") stateId: Int): Response<DistrictResponse>
}