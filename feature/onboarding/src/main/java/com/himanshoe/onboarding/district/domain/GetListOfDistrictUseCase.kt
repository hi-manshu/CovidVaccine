package com.himanshoe.onboarding.district.domain

import com.himanshoe.core.base.BaseUseCase
import com.himanshoe.core.util.Status
import com.himanshoe.onboarding.district.data.repository.DistrictRepository
import com.himanshoe.onboarding.district.data.response.DistrictResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListOfDistrictUseCase @Inject constructor(private val districtRepository: DistrictRepository) :
    BaseUseCase<Int, DistrictResponse> {
    override suspend fun invoke(input: Int): Flow<Status<DistrictResponse>> {
        return districtRepository.getDistricts(input)
    }
}