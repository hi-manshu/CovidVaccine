package com.himanshoe.onboarding.state.data.repository

import com.himanshoe.core.util.Status
import com.himanshoe.core.util.performNetworkCall
import com.himanshoe.onboarding.state.data.api.StateApiService
import com.himanshoe.onboarding.state.data.response.StateResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
class StateRepositoryImpl @Inject constructor(private val stateApiService: StateApiService) :
    StateRepository {

    override suspend fun getStates(): Flow<Status<StateResponse>> {
        return performNetworkCall {
            stateApiService.getStates()
        }
    }
}