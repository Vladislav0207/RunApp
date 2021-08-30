package com.vladislav07.runapp.ui.fragments.statisticsFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladislav07.runapp.domain.domainInteractor.DomainInteractorImpl
import com.vladislav07.runapp.ui.mapper.toStatisticsUI
import com.vladislav07.runapp.ui.models.StatisticsUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val domainInteractorImpl: DomainInteractorImpl
    ) : ViewModel() {

    val statisticsListLiveData = MutableLiveData<MutableList<StatisticsUI>>()

    fun getStatistics() {
       statisticsListLiveData.value = domainInteractorImpl.getStatistics().map {
           it.toStatisticsUI()
       }.toMutableList()
    }
}