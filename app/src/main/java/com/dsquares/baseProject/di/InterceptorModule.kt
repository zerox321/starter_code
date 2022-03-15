package com.dsquares.baseProject.di

import android.content.Context
import com.dsquares.baseProject.BuildConfig
import com.dsquares.baseProject.data.datasource.remote.interceptor.HeaderInterceptor
import com.dsquares.baseProject.data.datasource.remote.interceptor.StatusCodeInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InterceptorModule {


    //LoggingInterceptor
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }

    //HeaderInterceptor
    @Provides
    @Singleton
    fun provideHeaderInterceptor(): HeaderInterceptor = HeaderInterceptor()

    //StatusCodeInterceptor
    @Provides
    @Singleton
    fun provideStatusCodeInterceptor(@ApplicationContext context: Context) =
        StatusCodeInterceptor(context = context)


}
