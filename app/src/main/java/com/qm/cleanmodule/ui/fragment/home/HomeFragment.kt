package com.qm.cleanmodule.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.qm.cleanmodule.base.network.Status.*
import com.qm.cleanmodule.base.view.BaseFragment
import com.qm.cleanmodule.databinding.FragmentHomeBinding
import com.qm.cleanmodule.util.DialogsExtensions.showErrorDialog
import com.qm.cleanmodule.util.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//MARK:- HomeFragment  @Docs
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override fun pageTitle(): String = ""

    override val mViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}