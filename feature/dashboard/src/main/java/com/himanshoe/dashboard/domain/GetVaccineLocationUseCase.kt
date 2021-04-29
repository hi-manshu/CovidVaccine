package com.himanshoe.dashboard.domain

import com.himanshoe.dashboard.data.response.VaccineLocatorResponse
import com.himanshoe.core.base.BaseUseCase
import com.himanshoe.core.util.Status
import com.himanshoe.dashboard.data.repository.VaccineLocatorRepositoryImpl
import com.himanshoe.dashboard.data.request.VaccineLocatorRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVaccineLocationUseCase @Inject constructor(private val vaccineLocatorRepository: VaccineLocatorRepositoryImpl) :
    BaseUseCase<VaccineLocatorRequest, VaccineLocatorResponse> {

    override suspend fun invoke(input: VaccineLocatorRequest): Flow<Status<VaccineLocatorResponse>> {
        return vaccineLocatorRepository.getVaccineLocations(input)
    }
}