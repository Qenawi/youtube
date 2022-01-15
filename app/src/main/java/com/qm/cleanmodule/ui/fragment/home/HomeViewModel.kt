package com.qm.cleanmodule.ui.fragment.home

import android.app.Application
import android.provider.MediaStore
import androidx.lifecycle.*
import com.mabaat.androidapp.base.network.ResponseHandler
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.network.HandleResponseData
import com.qm.cleanmodule.base.network.response.NetworkResponse
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.data.model.SongStreamResponseModel
import com.qm.cleanmodule.data.remote.ErrorResponse
import com.qm.cleanmodule.util.AppUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import kotlin.time.measureTimedValue

//MARK:- HomeViewModel @Docs
@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val homeRepository: HomeRepository
) : AndroidBaseViewModel(app) {
    var searchKey: String? = ""

    fun download() {
        getData()
    }

    private fun getData() {
        isLoading.set(true)
        viewModelScope.launch(Dispatchers.IO) {

            val mb = try {
                homeRepository.getSongStreamUrl(
                    request = HomeRepository.HomeRequest(
                        unEncodedVideoUrl = searchKey
                    )
                )
            } catch (e: Exception) {
                NetworkResponse.UnknownError(error = e, code = null, headers = null)
            }
            withContext(Dispatchers.Main) {
                isLoading.set(false)
                when (mb) {
                    is Exception -> onError("fail")
                    is SongStreamResponseModel -> onSuccess(mb)

                }
            }
        }
    }

    private fun onSuccess(data: SongStreamResponseModel) {
        println(data.data?.downloadUrl)
    }

    private fun onError(error: String) {
        println("onError$error")
    }

}