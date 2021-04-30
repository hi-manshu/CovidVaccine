package com.himanshoe.search.data.repository

import com.himanshoe.core.util.Status
import com.himanshoe.core.util.performNetworkCall
import com.himanshoe.search.data.api.SearchByPinApiService
import com.himanshoe.search.data.request.SearchByPinRequest
import com.himanshoe.search.data.response.SearchByPinResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchByPinRepositoryImpl @Inject constructor(private val searchByPinApiService: SearchByPinApiService) :
    SearchByPinRepository {

    override suspend fun getVaccineLocations(searchByPinRequest: SearchByPinRequest): Flow<Status<SearchByPinResponse>> {
        return performNetworkCall {
            searchByPinApiService.getCenterByPin(
                searchByPinRequest.pinCode,
                searchByPinRequest.date
            )
        }
    }
}