package com.himanshoe.onboarding.district.data.repository

import com.himanshoe.core.util.Status
import com.himanshoe.core.util.performNetworkCall
import com.himanshoe.onboarding.district.data.api.DistrictApiService
import com.himanshoe.onboarding.district.data.response.DistrictResponse
import com.himanshoe.onboarding.state.data.api.StateApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
class DistrictRepositoryImpl @Inject constructor(private val districtApiService: DistrictApiService) :
    DistrictRepository {


    override suspend fun getDistricts(stateId: Int): Flow<Status<DistrictResponse>> {
       return performNetworkCall { districtApiService.getDistricts(stateId) }
    }
}