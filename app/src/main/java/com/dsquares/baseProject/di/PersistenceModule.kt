package com.dsquares.baseProject.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

//    @Provides
//    @Singleton
//    fun providePref(
//        @ApplicationContext appContext: Context,
//        profileAdapter: JsonAdapter<ProfileResponseData>,
//        locationAdapter: JsonAdapter<LocationModel>
//    ): Pref =
//        Pref(
//            context = appContext,
//            name = APPLICATION_ID,
//            defaultLang = appContext.getString(R.string.default_language),
//            profileAdapter = profileAdapter,
//            locationAdapter = locationAdapter
//        )
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDataBase =
//        Room.databaseBuilder(appContext, AppDataBase::class.java, "$APPLICATION_ID.DB")
//            .fallbackToDestructiveMigration()
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideCategoryDao(database: AppDataBase): CategoryDao = database.categoryDao()


}
