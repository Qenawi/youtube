package com.qm.cleanmodule.data.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//MARK:- ErrorResponse @Docs
@Parcelize
data class ErrorResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("validation")
	val validation: List<String?>? = null,
) : Parcelable
