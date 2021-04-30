package com.himanshoe.search.domain

import com.himanshoe.core.base.BaseUseCase
import com.himanshoe.core.util.Status
import com.himanshoe.search.data.repository.SearchByPinRepository
import com.himanshoe.search.data.request.SearchByPinRequest
import com.himanshoe.search.data.response.SearchByPinResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationByPinCodeUseCase @Inject constructor(private val searchByPinRepository: SearchByPinRepository) :
    BaseUseCase<SearchByPinRequest, SearchByPinResponse> {

    override suspend fun invoke(input: SearchByPinRequest): Flow<Status<SearchByPinResponse>> {
        return searchByPinRepository.getVaccineLocations(input)
    }
}