package com.vladislav07.runapp.ui.activity.loginActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladislav07.runapp.domain.domainInteractor.DomainInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val domainInteractorImpl: DomainInteractorImpl
    ) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _navigateNextLiveData = MutableLiveData<Boolean>()
    val navigateNextLiveData : LiveData<Boolean> get() = _navigateNextLiveData

    fun sendUUID (uuid : String) {
        compositeDisposable.add(domainInteractorImpl.sendUUID(uuid)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _navigateNextLiveData.value = true
                },{
                    _navigateNextLiveData.value = false
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