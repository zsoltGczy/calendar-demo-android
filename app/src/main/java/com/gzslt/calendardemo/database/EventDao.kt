package com.gzslt.calendardemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gzslt.calendardemo.data.database.EventDataModel
import com.gzslt.calendardemo.data.database.EventTuple

@Dao
interface EventDao {

    @Query("SELECT id, name, startDate, endDate, category, venue FROM EVENT")
    suspend fun getEvents(): List<EventTuple>

    @Insert
    suspend fun insertEvents(eventList: List<EventDataModel>)

    @Query("DELETE FROM Event")
    suspend fun clearEvents()
}
