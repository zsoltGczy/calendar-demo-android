package com.gzslt.calendardemo.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryApiModel(
    @field:Json(name = "name")
    val name: String,
) : BaseApiModel
