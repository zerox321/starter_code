package com.dsquares.baseProject.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RequestCache

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CoilCache
