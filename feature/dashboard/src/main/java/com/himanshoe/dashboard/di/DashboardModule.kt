package com.himanshoe.dashboard.di

import com.himanshoe.dashboard.data.api.DashboardApiService
import com.himanshoe.dashboard.data.repository.VaccineLocatorRepository
import com.himanshoe.dashboard.data.repository.VaccineLocatorRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DashboardModule {

    @Provides
    fun provideDashboardApiService(retrofit: Retrofit): DashboardApiService {
        return retrofit.create(DashboardApiService::class.java)
    }

    @Provides
    fun provideVaccineLocatorRepository(vaccineLocatorRepository: VaccineLocatorRepositoryImpl): VaccineLocatorRepository {
        return vaccineLocatorRepository
    }

}