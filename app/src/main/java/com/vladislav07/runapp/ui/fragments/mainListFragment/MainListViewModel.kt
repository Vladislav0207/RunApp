package com.vladislav07.runapp.ui.fragments.mainListFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladislav07.runapp.domain.domainInteractor.DomainInteractorImpl
import com.vladislav07.runapp.ui.mapper.toJogUI
import com.vladislav07.runapp.ui.mapper.toUserUI
import com.vladislav07.runapp.ui.models.JogUI
import com.vladislav07.runapp.ui.models.UserUI
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val domainInteractorImpl: DomainInteractorImpl
    ) : ViewModel() {

    private val _jogListLiveData = MutableLiveData<MutableList<JogUI>>()
    val jogListLiveData : LiveData<MutableList<JogUI>> get() = _jogListLiveData

    private val _userLiveData = MutableLiveData<UserUI>()
    val userLiveData : LiveData<UserUI> get() = _userLiveData

    private val compositeDisposable =CompositeDisposable()

    fun getJogs() {
        compositeDisposable.add(domainInteractorImpl.getJogs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { jogsAndUserDomain ->
                    _jogListLiveData.value = jogsAndUserDomain.jogs
                        .map { it.toJogUI() }.toMutableList()
                    _userLiveData.value = jogsAndUserDomain.user
                        .toUserUI()
                },{
                    it.printStackTrace()
                }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}