package com.example.androidnativeassignment.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.androidnativeassignment.db.TrackingDatabase
import com.example.androidnativeassignment.utils.Constants.TRACKING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTrackingDatabase(app: Context) =
        Room.databaseBuilder(app, TrackingDatabase::class.java, TRACKING_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTrackDao(db : TrackingDatabase) = db.getTrackDao()
}