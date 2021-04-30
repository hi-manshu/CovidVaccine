package com.himanshoe.onboarding.district.di

import com.himanshoe.onboarding.district.data.api.DistrictApiService
import com.himanshoe.onboarding.district.data.repository.DistrictRepository
import com.himanshoe.onboarding.district.data.repository.DistrictRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class DistrictModule {

    @Provides
    fun provideDistrictApiService(retrofit: Retrofit): DistrictApiService {
        return retrofit.create(DistrictApiService::class.java)
    }

    @Provides
    fun provideDistrictRepository(districtRepository: DistrictRepositoryImpl): DistrictRepository {
        return districtRepository
    }

}