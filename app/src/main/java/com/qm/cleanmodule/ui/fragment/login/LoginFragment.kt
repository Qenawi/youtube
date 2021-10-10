package com.qm.cleanmodule.ui.fragment.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.qm.cleanmodule.base.view.BaseFragment
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.databinding.FragmentLoginBinding
import com.qm.cleanmodule.util.DialogsExtensions.showErrorDialog
import com.qm.cleanmodule.util.navigateSafe
import com.qm.cleanmodule.util.observe
import javax.inject.Inject

//MARK:- LoginFragment @Docs
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
  override fun pageTitle(): String = ""

  override val mViewModel: LoginViewModel by viewModels()

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    mViewModel.apply {
      observe(mutableLiveData) {
        when (it) {
          Codes.BACK_BUTTON_PRESSED -> activity?.onBackPressed()
          Codes.HOME_SCREEN -> navigateSafe(
            LoginFragmentDirections.actionLoginFragmentToHomeFragment()
          )
        }
      }
      observe(resultLiveData) { activity?.showErrorDialog(it?.message) }
    }
  }
}