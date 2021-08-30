package com.vladislav07.runapp.ui.fragments.feedbackFragment

import androidx.lifecycle.ViewModel
import com.vladislav07.runapp.domain.domainInteractor.DomainInteractorImpl
import com.vladislav07.runapp.ui.mapper.toFeedbackDomain
import com.vladislav07.runapp.ui.models.FeedbackUI
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FeedbackViewModel @Inject constructor(
    private val domainInteractorImpl : DomainInteractorImpl
    ) : ViewModel() {

    fun sendFeedback(feedbackUI: FeedbackUI) {
        domainInteractorImpl.sendFeedback(feedbackUI.toFeedbackDomain())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}