package com.dsquares.baseProject.di

import com.dsquares.baseProject.datasource.repository.MenuRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dsquares.com.core.usecase.GetAllMenus

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {


    //GetAllMenus
    @Provides
    @ViewModelScoped
    fun provideGetAllMenus(menuRepo: MenuRepoImp): GetAllMenus = GetAllMenus(menuRepo = menuRepo)


}
