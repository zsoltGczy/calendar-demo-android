package com.gzslt.calendardemo.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventNameApiModel(
    @field:Json(name = "text")
    val text: String,
) : BaseApiModel
