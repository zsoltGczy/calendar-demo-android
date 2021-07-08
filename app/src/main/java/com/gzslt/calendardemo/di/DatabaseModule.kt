package com.gzslt.calendardemo.di

import android.content.Context
import androidx.room.Room
import com.gzslt.calendardemo.BuildConfig
import com.gzslt.calendardemo.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).build()

    fun provideEventDao(database: AppDatabase) = database.eventDao()
}
