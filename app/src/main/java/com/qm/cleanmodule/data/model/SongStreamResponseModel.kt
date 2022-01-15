package com.qm.cleanmodule.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// Created by BanqueMisr Developer Qenawi at 1/15/22.
@Parcelize
data class SongStreamResponseModel(
    @SerializedName("code")
    val statusCode: Int?,
    @SerializedName("msg")
    val statusMessage: String?,
    @SerializedName("data")
    val data: SongITemResponse?
) : Parcelable

@Parcelize
data class SongITemResponse(
    @SerializedName("streamUrl")
    val downloadUrl: String?
) : Parcelable
