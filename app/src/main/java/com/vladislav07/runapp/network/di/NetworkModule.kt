package com.vladislav07.runapp.network.di

import android.content.Context
import com.vladislav07.runapp.domain.NetworkRepository
import com.vladislav07.runapp.network.NetworkRepositoryImpl
import com.vladislav07.runapp.network.SessionManager
import com.vladislav07.runapp.network.retrofit.JogsApi
import com.vladislav07.runapp.network.retrofit.RetrofitClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository
}

