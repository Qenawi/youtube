package com.qm.cleanmodule.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Type

//MARK:- CalendarItem @Docs
@Entity
data class CalendarItem(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "DayNum") val dayNum: String?,
    @ColumnInfo(name = "DayName") val dayName: String?
)