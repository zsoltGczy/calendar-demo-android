package com.gzslt.calendardemo.data.database

import androidx.room.PrimaryKey

abstract class BaseDataModel {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
