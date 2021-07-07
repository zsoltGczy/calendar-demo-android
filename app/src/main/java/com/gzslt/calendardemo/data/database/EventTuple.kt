package com.gzslt.calendardemo.data.database

import java.util.Date

data class EventTuple(
    val id: Long,
    val name: String,
    val startDate: Date,
    val endDate: Date,
    val category: String,
    val venue: String,
) : BaseTuple
