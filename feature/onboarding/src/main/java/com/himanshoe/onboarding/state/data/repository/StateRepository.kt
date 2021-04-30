package com.himanshoe.onboarding.state.data.repository

import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.state.data.response.StateResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
interface StateRepository {

    suspend fun getStates(): Flow<Status<StateResponse>>
}