package com.dsquares.baseProject.di

import android.content.Context
import coil.ImageLoader
import coil.util.CoilUtils
import com.dsquares.baseProject.di.qualifier.CoilCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoilModule {

    //Hilt Provide Coil Cache
    @CoilCache
    @Provides
    @Singleton
    fun provideCoilCache(@ApplicationContext context: Context): Cache =
        CoilUtils.createDefaultCache(context)

    //Hilt Provide Coil Image Loader
    @Provides
    @Singleton
    fun provideImageLoader(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient
    ): ImageLoader = ImageLoader.Builder(context).apply {
        availableMemoryPercentage(0.25)
        crossfade(true)
        okHttpClient { okHttpClient }
    }.build()


}
