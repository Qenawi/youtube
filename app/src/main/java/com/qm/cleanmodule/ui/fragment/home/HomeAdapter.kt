package com.qm.cleanmodule.ui.fragment.home

import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.view.BaseAdapter
import com.qm.cleanmodule.base.view.BaseViewHolder

//MARK:- HomeAdapter @Docs
class HomeAdapter(itemClick: (HomeItem) -> Unit) : BaseAdapter<HomeItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_home_view
    override fun onViewHolderCreated(viewHolder: BaseViewHolder<HomeItem>) {

    }
}