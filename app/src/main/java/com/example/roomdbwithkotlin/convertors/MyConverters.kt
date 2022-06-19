package com.example.roomdbwithkotlin.convertors

import androidx.room.TypeConverter
import java.util.*


class MyConverters {

    @TypeConverter
    fun fromDateToLong(date:Date):Long{
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(long: Long):Date{
        return Date(long)
    }
}