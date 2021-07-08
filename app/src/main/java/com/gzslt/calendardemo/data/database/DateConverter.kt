package com.gzslt.calendardemo.data.database

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?) =
        value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?) =
        date?.time
}
