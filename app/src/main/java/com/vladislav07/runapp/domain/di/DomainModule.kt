package com.vladislav07.runapp.domain.di

import com.vladislav07.runapp.domain.domainInteractor.DomainInteractor
import com.vladislav07.runapp.domain.domainInteractor.DomainInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindDomainInteractorImpl(domainInteractorImpl : DomainInteractorImpl) : DomainInteractor
}