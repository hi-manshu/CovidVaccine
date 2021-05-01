package com.himanshoe.onboarding.state.data.api

import com.himanshoe.onboarding.state.data.response.StateResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
interface StateApiService {

    @GET("/api/v2/admin/location/states")
    suspend fun getStates(): Response<StateResponse>
}