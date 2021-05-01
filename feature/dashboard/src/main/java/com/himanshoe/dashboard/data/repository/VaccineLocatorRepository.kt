package com.himanshoe.dashboard.data.repository

import com.himanshoe.core.util.Status
import com.himanshoe.dashboard.data.request.VaccineLocatorRequest
import com.himanshoe.dashboard.data.response.VaccineLocatorResponse
import kotlinx.coroutines.flow.Flow

interface VaccineLocatorRepository {

    suspend fun getVaccineLocations(vaccineLocatorRequest: VaccineLocatorRequest): Flow<Status<VaccineLocatorResponse>>
}