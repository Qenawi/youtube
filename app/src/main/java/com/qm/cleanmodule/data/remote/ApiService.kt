package com.qm.cleanmodule.data.remote

import com.mabaat.androidapp.base.network.ResponseHandler
import com.qm.cleanmodule.base.network.HandleResponseData
import com.qm.cleanmodule.base.network.response.NetworkResponse
import com.qm.cleanmodule.ui.fragment.home.HomeRepository
import com.qm.cleanmodule.ui.fragment.home.HomeResponse
import com.qm.cleanmodule.ui.fragment.login.LoginRequest
import com.qm.cleanmodule.ui.fragment.login.LoginResponse
import com.qm.cleanmodule.util.Resource
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by MahmoudAyman on 6/24/2020.
 **/

interface ApiService {

  @GET("character")
//  fun getChars(@Query("page") page: Int): Flowable<Resource<HomeResponse>>
  fun getChars(@Query("page") page: Int): Flowable<HomeResponse>
}