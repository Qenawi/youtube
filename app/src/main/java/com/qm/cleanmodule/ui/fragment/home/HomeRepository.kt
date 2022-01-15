package com.qm.cleanmodule.ui.fragment.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import com.google.gson.annotations.SerializedName
import com.qm.cleanmodule.base.network.HandleResponseData
import com.qm.cleanmodule.base.network.IsRepo
import com.qm.cleanmodule.base.network.response.NetworkResponse
import com.qm.cleanmodule.data.model.SongStreamResponseModel
import com.qm.cleanmodule.data.remote.ApiService
import com.qm.cleanmodule.data.remote.ErrorResponse
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.parcel.Parcelize
import retrofit2.Response
import javax.inject.Inject

//MARK:- HomeRepository  @Docs
class HomeRepository @Inject constructor(private val apiService: ApiService) : IsRepo {



    suspend fun getSongStreamUrl(request:HomeRequest):SongStreamResponseModel
    {
    return apiService.getVideoStream(request.unEncodedVideoUrl)
    }

    data class HomeRequest(@SerializedName("test") val unEncodedVideoUrl: String?)
}
