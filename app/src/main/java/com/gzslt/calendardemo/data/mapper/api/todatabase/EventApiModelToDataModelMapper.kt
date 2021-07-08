package com.gzslt.calendardemo.data.mapper.api.todatabase

import com.gzslt.calendardemo.data.api.EventApiModel
import com.gzslt.calendardemo.data.database.EventDataModel
import javax.inject.Inject

class EventApiModelToDataModelMapper @Inject constructor() :
    ApiModelToDataModelMapper<EventApiModel, EventDataModel>() {

    override fun map(model: EventApiModel): EventDataModel =
        EventDataModel(
            name = model.name.text,
            startDate = model.startDate.date,
            endDate = model.endDate.date,
            category = model.category?.name ?: "uncategorized",
            venue = model.venue.name
        )
}
