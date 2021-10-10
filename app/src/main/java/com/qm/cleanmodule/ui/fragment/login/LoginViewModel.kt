package com.qm.cleanmodule.ui.fragment.login

import android.app.Application
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.constants.Codes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//MARK:-  LoginViewModel @Docs
@HiltViewModel
class LoginViewModel @Inject constructor(app: Application) : AndroidBaseViewModel(app) {

  val request = LoginRequest()
  fun onLoginClick() {
    setValue(Codes.HOME_SCREEN)
  }

  fun onBackClick() {
    setValue(Codes.BACK_BUTTON_PRESSED)
  }
}