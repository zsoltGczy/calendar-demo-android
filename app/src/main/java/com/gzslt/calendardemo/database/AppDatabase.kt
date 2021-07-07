package com.gzslt.calendardemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gzslt.calendardemo.BuildConfig
import com.gzslt.calendardemo.data.database.DateConverter
import com.gzslt.calendardemo.data.database.EventDataModel

@Database(
    entities = [
        EventDataModel::class
    ],
    version = BuildConfig.DATABASE_VERSION
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao
}
