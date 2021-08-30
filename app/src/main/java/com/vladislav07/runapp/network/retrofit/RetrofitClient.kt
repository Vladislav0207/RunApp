package com.vladislav07.runapp.network.retrofit

import android.content.Context
import com.vladislav07.runapp.network.retrofit.Constants.BASE_URL
import com.vladislav07.runapp.network.retrofit.Constants.CONNECT_TIMEOUT
import com.vladislav07.runapp.network.retrofit.Constants.READ_WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private fun getClient(context: Context) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(
             OkHttpClient().newBuilder()
                 .addInterceptor(LoginInterceptor(context))
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build()
        )
        .build()

    fun getJogsApi(context: Context): JogsApi = getClient(context).create(JogsApi::class.java)

}
