package com.himanshoe.onboarding.state.di

import com.himanshoe.onboarding.state.data.api.StateApiService
import com.himanshoe.onboarding.state.data.repository.StateRepository
import com.himanshoe.onboarding.state.data.repository.StateRepositoryImpl
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
class StateModule {

    @Provides
    fun provideStateApiService(retrofit: Retrofit): StateApiService {
        return retrofit.create(StateApiService::class.java)
    }

    @Provides
    fun provideStateRepository(stateRepository: StateRepositoryImpl): StateRepository {
        return stateRepository
    }

}