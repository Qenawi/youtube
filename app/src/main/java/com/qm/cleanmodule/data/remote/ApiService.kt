package com.qm.cleanmodule.data.remote

import com.qm.cleanmodule.base.network.response.NetworkResponse
import com.qm.cleanmodule.data.model.SongStreamResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by MahmoudAyman on 6/24/2020.
 **/

interface ApiService {
    companion object {
        private const val singleStreamUrl = "fetch_single_video"
    }

    @GET(singleStreamUrl)
    suspend fun getVideoStream(@Query("test" ,encoded = true) videoUrl: String?): SongStreamResponseModel
}