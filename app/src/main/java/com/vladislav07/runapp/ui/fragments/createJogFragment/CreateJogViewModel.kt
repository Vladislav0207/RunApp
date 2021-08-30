package com.vladislav07.runapp.ui.fragments.createJogFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladislav07.runapp.domain.domainInteractor.DomainInteractorImpl
import com.vladislav07.runapp.ui.mapper.toJogDomain
import com.vladislav07.runapp.ui.models.JogUI
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CreateJogViewModel @Inject constructor(
    private val domainInteractorImpl: DomainInteractorImpl
    ) : ViewModel() {

    private val _jogUpdateLiveData = MutableLiveData<JogUI?>()
    val jogUpdateLiveData : LiveData<JogUI?> get() = _jogUpdateLiveData
    private val _jogAddSuccessLiveData = MutableLiveData<Boolean?>()
    val jogAddSuccessLiveData : LiveData<Boolean?> get() = _jogAddSuccessLiveData
    private val compositeDisposable = CompositeDisposable()

    fun sendNewJog(jog: JogUI) {
        compositeDisposable.add(domainInteractorImpl.sendNewOrUpdateJog(jog.toJogDomain())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _jogAddSuccessLiveData.value = true
                }, {
                    _jogAddSuccessLiveData.value = false
                    it.printStackTrace()
                }
            )
        )
    }

    fun setJogForUpdate(jog: JogUI?){
        _jogUpdateLiveData.value = jog
    }

    fun cleanLiveDataValues(){
        _jogAddSuccessLiveData.value = null
        _jogUpdateLiveData.value = null
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}