package com.vladislav07.runapp.domain.domainInteractor

import com.vladislav07.runapp.domain.models.FeedbackDomain
import com.vladislav07.runapp.domain.models.JogDomain
import com.vladislav07.runapp.domain.models.JogsAndUserDomain
import com.vladislav07.runapp.domain.models.StatisticsDomain
import com.vladislav07.runapp.network.NetworkRepositoryImpl
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DomainInteractorImpl @Inject constructor(
    private val networkRepositoryImpl: NetworkRepositoryImpl
    ): DomainInteractor {

    override fun sendFeedback(feedbackDomain: FeedbackDomain): Completable {
        return networkRepositoryImpl.sendFeedback(feedbackDomain)
    }

    override fun getJogs(): Single<JogsAndUserDomain> {
        return networkRepositoryImpl.getJogs()
    }

    override fun getStatistics(): MutableList<StatisticsDomain> {
      return mutableListOf()
    }

    override fun sendNewOrUpdateJog(jog : JogDomain): Completable {
        return if (jog.userId == ""){
            networkRepositoryImpl.createNewJog(jog)
        } else{
            networkRepositoryImpl.updateJog(jog)
        }
    }

    override fun sendUUID(uuid: String): Completable {
       return networkRepositoryImpl.postUUID(uuid)
    }
}