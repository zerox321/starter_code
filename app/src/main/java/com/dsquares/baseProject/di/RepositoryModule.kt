package com.dsquares.baseProject.di

import com.dsquares.baseProject.datasource.remote.service.ApiService
import com.dsquares.baseProject.datasource.repository.MenuRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import dsquares.com.core.repository.MenuRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    //MenuRepo
    @Provides
    @Singleton
    fun provideMenuRepo(apiService: ApiService): MenuRepo = MenuRepoImp(apiService = apiService)
}
