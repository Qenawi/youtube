package com.qm.cleanmodule.ui.fragment.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.qm.cleanmodule.base.view.BaseFragment
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.databinding.FragmentSplashBinding
import com.qm.cleanmodule.util.navigateSafe
import com.qm.cleanmodule.util.observe

//MARK:-  SplashFragment  @Docs
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {
  override fun pageTitle(): String? = null

  override val mViewModel: SplashViewModel by viewModels()

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    mViewModel.apply {
      observe(mutableLiveData) {
        when (it) {
          Codes.LOGIN_SCREEN -> navigateSafe(
            SplashFragmentDirections.actionSplashFragmentToLoginFragment()
          )
        }
      }
    }
  }
}