package com.qm.Auth

import android.content.Context
import com.qm.cleanmodule.R
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Mockito.`when` as mWhen

//MARK:- SRC https://www.softwaretestinghelp.com/login-page-test-cases/
@RunWith(MockitoJUnitRunner::class)
class LoginTestCases {
  @Mock
  private lateinit var ctx: Context

  //MARK:- Functional Test Cases
  /**
   * Verify if a user will be able to login with a valid username and valid password -> (Positive)
   * Verify if a user cannot login with a valid username and an invalid password -> (Negative)
   * Verify the login page for both, when the field is blank and Submit button is clicked -> (Negative)
   * Verify the messages for invalid login -> (Positive)
   * Verify if the font, text color, and color coding of the Login page is as per the standard.
   * Verify if there is a ‘Cancel’ button available to erase the entered text.
   */
  @Test
  fun loginWithValidCredentialsSuccess() {
    mWhen(ctx.getString(R.string.search))
      .thenReturn("asd")
    val tst = ctx.getString(R.string.search)
    assertEquals(tst, "asd")
  }

  @Test
  fun loginWithValidCredentialsFail() {
  }

  //MARK:- NON Functional Test Cases (Security)
  /**
   * - Verify if a user cannot enter the characters more than
   * the specified range in each field (Username and Password) -> (Negative)
   *
   * - Verify if a user cannot enter the characters more than
   * the specified range in each field (Username and Password) -> (Positive)
   *
   *
   * */

}