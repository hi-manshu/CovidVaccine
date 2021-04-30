package com.himanshoe.onboarding.state.domain

import com.himanshoe.core.base.BaseUseCase
import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.state.data.repository.StateRepository
import com.himanshoe.onboarding.state.data.response.StateResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
class GetStatesUseCase @Inject constructor(private val stateRepository: StateRepository) :
    BaseUseCase<Unit, StateResponse> {
    override suspend fun invoke(input: Unit): Flow<Status<StateResponse>> {
        return stateRepository.getStates()
    }
}