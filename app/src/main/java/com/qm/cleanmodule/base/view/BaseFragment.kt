package com.qm.cleanmodule.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.qm.cleanmodule.BR
import com.qm.cleanmodule.ui.activity.MainActivity
import com.qm.cleanmodule.util.bindView
import com.qm.cleanmodule.util.castToActivity
import com.qm.cleanmodule.util.replaceFragment
import com.qm.cleanmodule.util.showKeyboard

/**
 * Created by MahmoudAyman on 6/17/2020.
 **/

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel> :
    Fragment() {

    abstract fun pageTitle(): String?

    protected abstract val mViewModel: VM

    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, mViewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeMainTitle(pageTitle())
    }

    fun closeFragment() {
        showKeyboard(false)
        activity?.onBackPressed()
    }

    fun showProgress(show: Boolean = true) {
        castToActivity<BaseActivity<*, *>> {
            it?.showProgress?.set(show)
        }
    }

    private fun changeMainTitle(title: String?) {
        castToActivity<MainActivity> {
            it?.changeTitle(title)
        }
    }

    inline fun <reified T : BaseFragment<*, *>> replaceFragment(
        bundle: Bundle? = null
    ) {
        activity?.replaceFragment<T>(bundle)
    }

    fun showBottomBar(show: Boolean = true) {
        castToActivity<MainActivity> {
            it?.showBottomBar(show)
        }
    }


    override fun onPause() {
        super.onPause()
        showProgress(false)
    }

}
