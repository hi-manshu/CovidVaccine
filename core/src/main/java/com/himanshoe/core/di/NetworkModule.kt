package com.himanshoe.core.di

import com.himanshoe.core.BuildConfig
import com.himanshoe.core.util.UserAgentInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Himanshu Singh on 24-10-2020.
 **/
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        const val BASE_URL = "baseUrl"
        const val STREAM_BASE_URL = "streamBaseUrl"
    }

    @Provides
    fun provideUserAgentInterceptor(): UserAgentInterceptor {
        return UserAgentInterceptor()
    }

    @Provides
    fun provideOkHttpClient(
        userAgentInterceptor: UserAgentInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient
            .Builder()
            .addInterceptor(userAgentInterceptor)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }
}
