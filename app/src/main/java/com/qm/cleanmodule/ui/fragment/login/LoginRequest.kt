package com.qm.cleanmodule.ui.fragment.login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//MARK:- LoginRequest @Docs
@Parcelize
data class LoginRequest(
  var email: String? = null,
  var password: String? = null
) : Parcelable {

  fun isValid(): Boolean {
    return !email.isNullOrEmpty() &&
      !password.isNullOrEmpty()
  }
}