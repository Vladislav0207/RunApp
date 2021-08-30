package com.vladislav07.runapp.domain

import com.vladislav07.runapp.domain.models.FeedbackDomain
import com.vladislav07.runapp.domain.models.JogDomain
import com.vladislav07.runapp.domain.models.JogsAndUserDomain
import io.reactivex.Completable
import io.reactivex.Single

interface NetworkRepository {
    fun postUUID(uuid : String): Completable

    fun getJogs(): Single<JogsAndUserDomain>

    fun createNewJog(jogDomain: JogDomain): Completable

    fun updateJog(jogDomain: JogDomain): Completable

    fun sendFeedback(feedbackDomain: FeedbackDomain) : Completable
}