package com.qm.cleanmodule.data.model

//MARK:- ListDataItem @Docs
data class ListDataItem(var id: Int? = null, var name: String? = null) {
    companion object {
        fun getDummyData(): ArrayList<ListDataItem> = arrayListOf(
            ListDataItem(1, "First"),
            ListDataItem(2, "Second"),
            ListDataItem(3, "Third")
        )
    }
}