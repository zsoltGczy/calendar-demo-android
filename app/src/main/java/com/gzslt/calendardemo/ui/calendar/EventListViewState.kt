package com.gzslt.calendardemo.ui.calendar

import com.gzslt.calendardemo.model.EventPresentationModel

sealed class EventListViewState

object Loading : EventListViewState()

data class Error(val message: String) : EventListViewState()

data class EventListLoaded(val eventList: List<EventPresentationModel>) : EventListViewState()
