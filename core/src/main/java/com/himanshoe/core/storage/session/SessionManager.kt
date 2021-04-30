package com.himanshoe.core.storage.session

interface SessionManager {

    suspend fun saveStateId(stateId: Int)

    suspend fun getStateId(): Int

    suspend fun saveDistrictId(districtId: Int)

    suspend fun getDistrictId(): Int

    suspend fun isOnboardingDone(status:Boolean)

    suspend fun isOnboardingDone():Boolean

    suspend fun getCurrentDate():String
}