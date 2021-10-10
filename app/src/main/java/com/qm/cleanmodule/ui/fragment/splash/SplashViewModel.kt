package com.qm.cleanmodule.ui.fragment.splash

import androidx.databinding.ObservableBoolean
import com.qm.cleanmodule.base.viewmodel.BaseViewModel
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.util.KtCoroutine
import kotlinx.coroutines.delay

//MARK:- SplashViewModel @Docs
class SplashViewModel : BaseViewModel() {

  init {
    KtCoroutine.delayJob(1) {
      postValue(Codes.LOGIN_SCREEN)
    }
  }
}