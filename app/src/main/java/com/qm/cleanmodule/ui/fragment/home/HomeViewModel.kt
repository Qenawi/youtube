package com.qm.cleanmodule.ui.fragment.home

import android.app.Application
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.network.HandleResponseData
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.util.AppUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject
import kotlin.time.measureTimedValue

//MARK:- HomeViewModel @Docs
@HiltViewModel
class HomeViewModel @Inject constructor(
  app: Application,
  private val homeRepository: HomeRepository
) : AndroidBaseViewModel(app) {

  private var usersLivedata = MediatorLiveData<HandleResponseData<HomeResponse>>()

  val adapter = HomeAdapter(::onItemClick)

  private fun onItemClick(homeItem: HomeItem) {
    setValue(homeItem)
  }

  fun loadDataOnAdapter(results: List<HomeItem?>?) {
    results?.let {
      adapter.setList(it)
    }
  }

  init {
    getData()
  }

  private fun getData() {
    if (!AppUtil.isNetworkAvailable(app)) {
      usersLivedata.postValue(HandleResponseData.error(msg = app.getString(R.string.network_error)))
      return
    }

    usersLivedata = homeRepository.getUsers(1)
    usersLivedata.postValue(HandleResponseData.loading())
  }

  fun observeUsers(): LiveData<HandleResponseData<HomeResponse>> = usersLivedata
}