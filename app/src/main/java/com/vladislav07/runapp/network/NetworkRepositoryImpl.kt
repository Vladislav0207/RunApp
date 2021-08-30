package com.vladislav07.runapp.network

import android.content.Context
import com.vladislav07.runapp.domain.NetworkRepository
import com.vladislav07.runapp.domain.models.FeedbackDomain
import com.vladislav07.runapp.domain.models.JogDomain
import com.vladislav07.runapp.domain.models.JogsAndUserDomain
import com.vladislav07.runapp.network.mapper.toFeedbackRequest
import com.vladislav07.runapp.network.mapper.toJogNewRequest
import com.vladislav07.runapp.network.mapper.toJogUpdateRequest
import com.vladislav07.runapp.network.mapper.toJogsAndUserDomain
import com.vladislav07.runapp.network.models.request.UUIDRequest
import com.vladislav07.runapp.network.retrofit.JogsApi
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val jogsApi : JogsApi,
    private val sessionManager: SessionManager
) : NetworkRepository {

    override fun postUUID(uuid: String): Completable {
        return Completable.fromSingle(
            jogsApi
                .loginUUID(UUIDRequest(uuid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    sessionManager.saveAuthToken(it.response.accessToken)
                }
        )
    }

    override fun getJogs(): Single<JogsAndUserDomain> {
        return jogsApi
            .getJogs()
            .map { it.toJogsAndUserDomain() }
    }

    override fun createNewJog(jogDomain: JogDomain): Completable {
        val jogRequest = jogDomain.toJogNewRequest()
        return jogsApi
            .createNewJog(jogRequest)
    }

    override fun updateJog(jogDomain: JogDomain): Completable {
        val jogRequest = jogDomain.toJogUpdateRequest()
        return jogsApi.updateJog(jogRequest)
    }

    override fun sendFeedback(feedbackDomain: FeedbackDomain): Completable {
        return jogsApi
            .sendFeedback(feedbackDomain.toFeedbackRequest())
    }


}