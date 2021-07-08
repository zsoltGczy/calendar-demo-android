package com.gzslt.calendardemo.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventRequestApiModel(
    @field:Json(name = "events")
    val eventList: List<EventApiModel>,
) : BaseApiModel
