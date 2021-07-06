package com.gzslt.calendardemo.api

import com.gzslt.calendardemo.BuildConfig
import com.gzslt.calendardemo.data.api.EventRequestApiModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.Date

interface EventService {

    @GET("v3/venues/23862015/events/?expand=venue,category&token=${BuildConfig.EVENTS_API_KEY}")
    suspend fun getEvents(): Response<EventRequestApiModel>

    companion object {
        private const val BASE_URL = "https://www.eventbriteapi.com/"

        fun create(): EventService {
            val moshi = Moshi.Builder()
                .add(Date::class.java, Rfc3339DateJsonAdapter())
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(EventService::class.java)
        }
    }
}
