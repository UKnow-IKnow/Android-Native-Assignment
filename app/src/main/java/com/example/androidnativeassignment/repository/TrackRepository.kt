package com.example.androidnativeassignment.repository

import com.example.androidnativeassignment.db.Track
import com.example.androidnativeassignment.db.TrackDAO
import javax.inject.Inject

class TrackRepository @Inject constructor(
    val trackDAO: TrackDAO
) {
    suspend fun insertTrack(track: Track) = trackDAO.insertTrack(track)

    suspend fun deleteTrack(track: Track) = trackDAO.deleteTrack(track)

    fun getAllTracksSortedByDate() = trackDAO.getAllTracksSortedByDate()

    fun getAllTracksSortedByTimeInMillis() = trackDAO.getAllTracksSortedByTimeInMillis()

    fun getAllTracksSortedByDistance() = trackDAO.getAllTracksSortedByDistance()

    fun getTotalDistance() = trackDAO.getTotalDistance()

    fun getTotalTimeInMillis() = trackDAO.getTotalTimeInMillis()

}