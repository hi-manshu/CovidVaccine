package com.himanshoe.search.data.repository

import com.himanshoe.core.util.Status
import com.himanshoe.search.data.request.SearchByPinRequest
import com.himanshoe.search.data.response.SearchByPinResponse
import kotlinx.coroutines.flow.Flow

interface SearchByPinRepository {

    suspend fun getVaccineLocations(searchByPinRequest: SearchByPinRequest): Flow<Status<SearchByPinResponse>>
}