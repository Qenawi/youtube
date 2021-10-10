package com.qm.cleanmodule.util

import android.content.Context
import cn.pedant.SweetAlert.SweetAlertDialog
import com.qm.cleanmodule.R

//MARK:- DialogsExtensions @Docs
object DialogsExtensions {
  fun Context.showErrorDialog(
    message: String?,
    onClick: () -> Unit = {}
  ) {
    SweetAlertDialog(
      this,
      SweetAlertDialog.ERROR_TYPE
    )
      .setContentText(message)
      .setConfirmButton(getString(R.string.continue_)) { sDialog ->
        sDialog.closeDialog()
        onClick()
      }
      .show()


    fun Context.showSuccessfulDialog(
      message: String?,
      onClick: () -> Unit = {}
    ) {
      val dialog = SweetAlertDialog(
        this,
        SweetAlertDialog.SUCCESS_TYPE
      )
        .setConfirmButton(getString(R.string.yes)) { sDialog ->
          sDialog.closeDialog()
          onClick()
        }.setCancelButton(getString(R.string.no)) {
          it.closeDialog()
        }
        .setConfirmButtonBackgroundColor(getColorFromRes(R.color.colorPrimary))
      message?.let {
        dialog.setContentText(message)
      }
      dialog.show()
    }
  }
}