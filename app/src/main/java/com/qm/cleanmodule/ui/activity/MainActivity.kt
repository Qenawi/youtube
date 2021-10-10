package com.qm.cleanmodule.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.view.BaseActivity
import com.qm.cleanmodule.constants.Codes
import com.qm.cleanmodule.databinding.ActivityMainBinding
import com.qm.cleanmodule.util.observe
import com.qm.cleanmodule.util.showExitDialog
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import javax.inject.Inject

//MARK:- MainActivity @Docs
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
  NavController.OnDestinationChangedListener {

  override val mViewModel: MainViewModel by viewModels()
  private var navController: NavController? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setupNavController()
    mViewModel.apply {
      observe(mutableLiveData) {
        when (it) {
          Codes.BACK_BUTTON_PRESSED -> onBackPressed()
        }
      }
    }
    binding.obsProgressBar = showProgress
  }

  private fun getNumberOfDays(
    year: Int,
    month: Int
  ): Int {
    val calendar: Calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month - 1)
    return calendar.getActualMaximum(Calendar.DATE)
  }

  private fun setupNavController() {
    val navHostFragment =
      supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
    navController = navHostFragment.navController
    navController?.addOnDestinationChangedListener(this)
  }

  fun changeTitle(title: String?) {
    title?.let {
      mViewModel.obsTitle.set(title)
    } ?: Timber.e("title is null")
  }

  fun showBottomBar(show: Boolean = true) {
    mViewModel.obsShowBottomBar.set(show)
  }

  override fun onDestinationChanged(
    controller: NavController,
    destination: NavDestination,
    arguments: Bundle?
  ) {
    destination.id.let { id ->
      mViewModel.setScreenPermissions(id)
    }
  }

  override fun onBackPressed() {
    when (navController?.currentDestination?.id) {
      R.id.loginFragment -> {
        showExitDialog()
      }
      R.id.splashFragment -> {
      }
      else -> {
        super.onBackPressed()
      }
    }
  }
}
