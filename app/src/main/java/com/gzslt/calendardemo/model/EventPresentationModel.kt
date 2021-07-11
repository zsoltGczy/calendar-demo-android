package com.gzslt.calendardemo.model

import java.time.LocalDateTime

data class EventPresentationModel(
    val id: Long,
    val name: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val category: String,
    val venue: String,
) : BasePresentationModel
