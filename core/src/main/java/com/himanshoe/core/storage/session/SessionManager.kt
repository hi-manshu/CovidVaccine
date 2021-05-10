package com.himanshoe.core.storage.session

interface SessionManager {

    suspend fun saveStateId(stateId: Int)

    suspend fun saveStateName(name:String)

    suspend fun saveDistrictName(name:String)

    suspend fun getStateId(): Int

    suspend fun getStateName(): String

    suspend fun getDistrictName(): String

    suspend fun saveDistrictId(districtId: Int)

    suspend fun saveAgeFilter(age: String)

    suspend fun getAgeFilter():String

    suspend fun getDistrictId(): Int

    suspend fun isOnboardingDone(status:Boolean)

    suspend fun isOnboardingDone():Boolean

    suspend fun getCurrentDate():String

    suspend fun dismissBanner()

    suspend fun savePinCodeForDistrict(pinCode:String)

    suspend fun getPinCodeForDistrict():String

    suspend fun isBannerDismissed() :Boolean
}