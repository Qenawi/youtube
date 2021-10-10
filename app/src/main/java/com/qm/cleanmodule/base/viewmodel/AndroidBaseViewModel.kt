package com.qm.cleanmodule.base.viewmodel

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.qm.cleanmodule.ui.fragment.home.HomeResponse
import com.qm.cleanmodule.util.Resource

//MARK:- AndroidBaseViewModel@Docs
open class AndroidBaseViewModel(val app: Application) : AndroidViewModel(app), Observable {
    private val mCallBacks: PropertyChangeRegistry = PropertyChangeRegistry()
    val mutableLiveData = MutableLiveData<Any?>()
    var isLoading = ObservableBoolean()

    //MARK:- for network
    val resultLiveData = MutableLiveData<Resource<Any?>>()

    //MARK:- todo @Mayaman add Docs
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallBacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallBacks.add(callback)
    }

    fun notifyChange() {
        mCallBacks.notifyChange(this, 0)
    }

    fun notifyChange(propertyId: Int) {
        mCallBacks.notifyChange(this, propertyId)
    }

    fun setValue(o: Any?) {
        mutableLiveData.value = o
    }

    fun postValue(o: Any?) {
        mutableLiveData.postValue(o)
    }

    fun setResult(o: Resource<Any?>) {
        resultLiveData.value = o
    }

    fun postResult(o: Resource<Any?>) {
        resultLiveData.postValue(o)
    }

}