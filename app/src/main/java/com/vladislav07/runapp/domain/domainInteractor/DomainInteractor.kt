package com.vladislav07.runapp.domain.domainInteractor

import com.vladislav07.runapp.domain.models.FeedbackDomain
import com.vladislav07.runapp.domain.models.JogDomain
import com.vladislav07.runapp.domain.models.JogsAndUserDomain
import com.vladislav07.runapp.domain.models.StatisticsDomain
import io.reactivex.Completable
import io.reactivex.Single

interface DomainInteractor {
    fun sendFeedback(feedbackDomain: FeedbackDomain): Completable

    fun getJogs(): Single<JogsAndUserDomain>

    fun getStatistics(): MutableList<StatisticsDomain>

    fun sendNewOrUpdateJog(jog : JogDomain): Completable

    fun sendUUID(uuid: String): Completable
}