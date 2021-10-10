package com.qm.cleanmodule.ui.activity

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.constants.Codes

class MainViewModel(app: Application) : AndroidBaseViewModel(app) {

    val obsTitle = ObservableField<String>()
    val obsShowMainToolbarIcons = ObservableBoolean()
    val obsShowBackButton = ObservableBoolean()
    val obsShowBottomBar = ObservableBoolean()
    val obsShowHeaderView = ObservableBoolean()



    fun onLogoutClick() {
        setValue(Codes.LOG_OUT)
    }

    fun onBackClick() {
        setValue(Codes.BACK_BUTTON_PRESSED)
    }

    fun setScreenPermissions(id: Int) {
    }

    private fun authScreenPermissions() { //hide all headers
        obsShowBottomBar.set(false)
        obsShowBackButton.set(false)
        obsShowMainToolbarIcons.set(false)
    }

    private fun mainScreenPermissions() { //show bottom bar and toolbar with all buttons
        obsShowBottomBar.set(true)
        obsShowMainToolbarIcons.set(true)
        obsShowBackButton.set(false)
        obsShowHeaderView.set(true)

    }

    private fun detailsScreen() {// show back button with logo in toolbar
        obsShowBottomBar.set(false)
        obsShowMainToolbarIcons.set(false)
        obsShowBackButton.set(true)
        obsShowHeaderView.set(true)
    }


}