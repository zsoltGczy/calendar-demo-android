package com.gzslt.calendardemo.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventApiModel(
    @field:Json(name = "name")
    val name: EventNameApiModel,
    @field:Json(name = "start")
    val startDate: StartOrEndApiModel,
    @field:Json(name = "end")
    val endDate: StartOrEndApiModel,
    @field:Json(name = "category")
    val category: CategoryApiModel?,
    @field:Json(name = "venue")
    val venue: VenueApiModel,
) : BaseApiModel
