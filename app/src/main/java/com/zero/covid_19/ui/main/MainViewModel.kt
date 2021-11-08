package com.zero.covid_19.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oratakashi.viewbinding.core.binding.livedata.liveData
import com.zero.covid_19.data.api.ApiEndpoint
import com.zero.covid_19.utils.NetworkHelper
import com.zero.covid_19.utils.SimpleState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val endpoint: ApiEndpoint,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    val stateGeneral: MutableLiveData<SimpleState> by liveData()

    fun getGeneral() {
        endpoint.getGeneral()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<SimpleState>(SimpleState::Result)
            .onErrorReturn(SimpleState::Error)
            .toFlowable()
            .startWith(SimpleState.Loading)
            .subscribe(stateGeneral::postValue)
            .let { return@let CompositeDisposable::add }
    }
}