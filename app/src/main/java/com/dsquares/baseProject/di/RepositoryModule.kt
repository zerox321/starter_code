package com.dsquares.baseProject.di

import com.dsquares.baseProject.datasource.remote.service.ApiService
import com.dsquares.baseProject.datasource.repository.MenuRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {


    //MenuRepo
    @Provides
    @ActivityRetainedScoped
    fun provideMenuRepoImp(apiService: ApiService): MenuRepoImp = MenuRepoImp(apiService = apiService)


}
