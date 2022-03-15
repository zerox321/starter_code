package com.dsquares.baseProject.di

import android.content.Context
import com.dsquares.baseProject.BuildConfig.baseUrl
import com.dsquares.baseProject.data.EndPoint
import com.dsquares.baseProject.data.EndPoint.CACHE_SIZE
import com.dsquares.baseProject.data.datasource.remote.interceptor.HeaderInterceptor
import com.dsquares.baseProject.data.datasource.remote.interceptor.StatusCodeInterceptor
import com.dsquares.baseProject.data.datasource.remote.service.ApiService
import com.dsquares.baseProject.di.qualifier.CoilCache
import com.dsquares.baseProject.di.qualifier.RequestCache
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //    Hilt Provide Network Cache
    @RequestCache
    @Provides
    @Singleton
    fun provideRequestCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, CACHE_SIZE)


    //OkHttpClient
    @Provides
    @Singleton
    fun provideOkHttpClient(
        @RequestCache requestCache: Cache,
        @CoilCache coilCache: Cache,
        headerInterceptor: HeaderInterceptor,
        statusCodeInterceptor: StatusCodeInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder().apply {

            connectTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            readTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            writeTimeout(EndPoint.timeOut, TimeUnit.SECONDS)

            addInterceptor(headerInterceptor)
            addInterceptor(statusCodeInterceptor)
            addInterceptor(loggingInterceptor)

            cache(requestCache)
            cache(coilCache)


        }.build()


    //Retrofit
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
        coroutineCallAdapterFactory: CoroutineCallAdapterFactory
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(coroutineCallAdapterFactory)
            .build()

    //ApiService
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


}
