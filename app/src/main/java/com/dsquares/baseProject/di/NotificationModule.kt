package com.dsquares.baseProject.di

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    //Hilt Provide Remote ConfigSettings
    @Provides
    @Singleton
    fun provideConfigSettings(): FirebaseRemoteConfigSettings =
        remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600

        }

    //Hilt Provide  FirebaseMessaging
    @Provides
    @Singleton
    fun provideRemoteConfig(configSettings: FirebaseRemoteConfigSettings): FirebaseRemoteConfig =
        Firebase.remoteConfig.apply {
            setConfigSettingsAsync(configSettings)
        }


}
