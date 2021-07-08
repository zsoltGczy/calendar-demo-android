package com.gzslt.calendardemo.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class StartOrEndApiModel(
    @field:Json(name = "utc")
    val date: Date
) : BaseApiModel
