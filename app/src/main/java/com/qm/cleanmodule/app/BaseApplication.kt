package com.qm.cleanmodule.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import cn.pedant.SweetAlert.BuildConfig
import com.qm.cleanmodule.databinding.AppDataBindingComponent
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import timber.log.Timber
import timber.log.Timber.DebugTree

//MARK:-  BaseApplication @Docs

@HiltAndroidApp
open class BaseApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      initTimber()
    }
    DataBindingUtil.setDefaultComponent(AppDataBindingComponent())
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    //MARK:- handle error with out subscribe
    RxJavaPlugins.setErrorHandler(Timber::e)
  }

  private fun initTimber() {
    Timber.plant(object : DebugTree() {
      override fun createStackElementTag(element: StackTraceElement): String? {
        return super.createStackElementTag(element) + "line: " + element.lineNumber
      }
    })
  }
}