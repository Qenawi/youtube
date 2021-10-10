package com.qm.cleanmodule.ui.fragment.home

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.qm.cleanmodule.base.view.BaseParcelable
import kotlinx.parcelize.Parcelize

//MARK:- HomeResponse @Docs
@Parcelize
data class HomeResponse(

  @field:SerializedName("results")
  val results: List<HomeItem?>? = null,

  @field:SerializedName("info")
  val info: Info? = null,
  @Expose
  val message: String? = null,
  @Expose
  val code: Int = 200

) : Parcelable

@Parcelize
data class Location(

  @field:SerializedName("name")
  val name: String? = null,

  @field:SerializedName("url")
  val url: String? = null
) : Parcelable

@Parcelize
data class Info(

  @field:SerializedName("next")
  val next: String? = null,

  @field:SerializedName("pages")
  val pages: Int? = null,

  @field:SerializedName("prev")
  val prev: String? = null,

  @field:SerializedName("count")
  val count: Int? = null
) : Parcelable

@Parcelize
data class Origin(

  @field:SerializedName("name")
  val name: String? = null,

  @field:SerializedName("url")
  val url: String? = null
) : Parcelable

@Parcelize
data class HomeItem(

  @field:SerializedName("image")
  val image: String? = null,

  @field:SerializedName("gender")
  val gender: String? = null,

  @field:SerializedName("species")
  val species: String? = null,

  @field:SerializedName("created")
  val created: String? = null,

  @field:SerializedName("origin")
  val origin: Origin? = null,

  @field:SerializedName("name")
  val name: String? = null,

  @field:SerializedName("location")
  val location: Location? = null,

  @field:SerializedName("episode")
  val episode: List<String?>? = null,

  @field:SerializedName("id")
  val id: Int = 0,

  @field:SerializedName("type")
  val type: String? = null,

  @field:SerializedName("url")
  val url: String? = null,

  @field:SerializedName("status")
  val status: String? = null
) : Parcelable, BaseParcelable {
  override fun unique() = id
}
