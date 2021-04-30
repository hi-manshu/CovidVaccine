package com.himanshoe.search.di

import com.himanshoe.search.data.api.SearchByPinApiService
import com.himanshoe.search.data.repository.SearchByPinRepository
import com.himanshoe.search.data.repository.SearchByPinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class SearchByPinModule {

    @Provides
    fun provideSearchByPinApiService(retrofit: Retrofit): SearchByPinApiService {
        return retrofit.create(SearchByPinApiService::class.java)
    }

    @Provides
    fun provideSearchByPinRepository(searchByPinRepository: SearchByPinRepositoryImpl): SearchByPinRepository {
        return searchByPinRepository
    }
}