package com.vladislav07.runapp.network.retrofit

import android.content.Context
import com.vladislav07.runapp.network.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class LoginInterceptor(context:Context) :Interceptor {
    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "bearer $it")
        }
        return chain.proceed(requestBuilder.build())
    }
}