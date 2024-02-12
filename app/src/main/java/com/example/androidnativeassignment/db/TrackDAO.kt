package com.example.androidnativeassignment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface TrackDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrack(track: Track)

    @Delete
    suspend fun deleteTrack(track: Track)

    @Query("SELECT * FROM tracking_table ORDER BY timeStamp DESC")
    fun getAllTracksSortedByDate(): LiveData<List<Track>>

    @Query("SELECT * FROM tracking_table ORDER BY distanceInMeter DESC")
    fun getAllTracksSortedByDistance(): LiveData<List<Track>>

    @Query("SELECT * FROM tracking_table ORDER BY timeInMillis DESC")
    fun getAllTracksSortedByTimeInMillis(): LiveData<List<Track>>

    @Query("SELECT SUM(timeInMillis) FROM tracking_table")
    fun getTotalTimeInMillis(): LiveData<List<Long>>

    @Query("SELECT SUM(distanceInMeter) FROM tracking_table")
    fun getTotalDistance(): LiveData<List<Long>>
}