package com.gzslt.calendardemo.data.mapper.database.toPresentation

import com.gzslt.calendardemo.data.database.EventTuple
import com.gzslt.calendardemo.model.EventPresentationModel
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

class EventTupleToPresentationModelMapper @Inject constructor() :
    TupleToPresentationModelMapper<EventTuple, EventPresentationModel>() {

    private fun dateToLocalDate(date: Date): LocalDateTime =
        date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()

    override fun map(model: EventTuple): EventPresentationModel =
        EventPresentationModel(
            id = model.id,
            name = model.name,
            startDate = dateToLocalDate(model.startDate),
            endDate = dateToLocalDate(model.endDate),
            category = model.category,
            venue = model.venue,
        )
}
