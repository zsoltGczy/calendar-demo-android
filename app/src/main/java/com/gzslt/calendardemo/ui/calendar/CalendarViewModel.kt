package com.gzslt.calendardemo.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gzslt.calendardemo.api.EventService
import com.gzslt.calendardemo.data.api.EventApiModel
import com.gzslt.calendardemo.data.mapper.api.todatabase.EventApiModelToDataModelMapper
import com.gzslt.calendardemo.data.mapper.database.toPresentation.EventTupleToPresentationModelMapper
import com.gzslt.calendardemo.database.EventDao
import com.gzslt.calendardemo.model.EventPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val eventService: EventService,
    private val eventDao: EventDao,
    private val apiModelToDataModelMapper: EventApiModelToDataModelMapper,
    private val tupleToPresentationModelMapper: EventTupleToPresentationModelMapper,
) : ViewModel() {

    private val _viewState = MutableLiveData<EventListViewState>()
    val viewState: LiveData<EventListViewState>
        get() = _viewState

    init {
        _viewState.value = Loading
    }

    fun loadEventList() {
        viewModelScope.launch {
            _viewState.value = Loading

            try {
                val response = eventService.getEvents()

                if (response.isSuccessful) {
                    val eventRequestApiModel = response.body()

                    if (eventRequestApiModel != null) {
                        _viewState.value =
                            EventListLoaded(saveAndReturnEventList(eventRequestApiModel.eventList))
                    } else {
                        _viewState.value = Error("Response body is empty")
                    }
                } else {
                    _viewState.value = Error("Bad response: HTTP ${response.code()}")
                }
            } catch (e: Exception) {
                _viewState.value = Error("Unknown error ${e.message}")
            }
        }
    }

    private suspend fun saveAndReturnEventList(
        eventList: List<EventApiModel>
    ): List<EventPresentationModel> {
        with(eventDao) {
            clearEvents()
            insertEvents(apiModelToDataModelMapper.map(eventList))

            return tupleToPresentationModelMapper.map(getEvents())
        }
    }
}
