package com.qm.cleanmodule.ui.fragment.bottomsheet

import android.widget.Filter
import android.widget.Filterable
import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.view.BaseAdapter
import com.qm.cleanmodule.base.view.BaseViewHolder
import com.qm.cleanmodule.data.model.SearchItemInterface
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList


//MARK:- SearchAdapter @Docs
class SearchAdapter(itemCallback: (SearchItemInterface) -> Unit) : BaseAdapter<SearchItemInterface>(itemCallback),
    Filterable {
    override fun layoutRes(): Int = R.layout.item_search_list_view

    override fun onViewHolderCreated(viewHolder: BaseViewHolder<SearchItemInterface>) {

    }
    var filteredItemsList = arrayListOf<SearchItemInterface?>()
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
                filteredItemsList = filterResults.values as ArrayList<SearchItemInterface?>
                Timber.e("$filteredItemsList")
                submitList(filteredItemsList.toMutableList())
            }

            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val queryString = charSequence?.toString()?.toLowerCase(Locale.ROOT)
                val filterResults = FilterResults()
                filterResults.values = if (queryString.isNullOrEmpty()) {
                    mCurrentList
                }
                else
                    mCurrentList.filter {
                        it?.name()?.toLowerCase(Locale.ROOT)?.contains(queryString)!!
                    }
                return filterResults
            }
        }
    }
}