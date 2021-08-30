package com.vladislav07.runapp.network.di

import android.content.Context
import com.vladislav07.runapp.network.retrofit.JogsApi
import com.vladislav07.runapp.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideJogsApi(@ApplicationContext context: Context): JogsApi {
        return RetrofitClient.getJogsApi(context)
    }
}