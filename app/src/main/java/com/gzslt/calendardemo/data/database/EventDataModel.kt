package com.gzslt.calendardemo.data.database

import androidx.room.Entity
import java.util.Date

@Entity(
    tableName = "Event"
)
data class EventDataModel(
    val name: String,
    val startDate: Date,
    val endDate: Date,
    val category: String,
    val venue: String
) : BaseDataModel()
