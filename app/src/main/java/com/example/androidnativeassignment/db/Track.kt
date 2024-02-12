package com.example.androidnativeassignment.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tracking_table")
data class Track(
    var img: Bitmap? = null,
    var timeStamp: Long = 0L,
    var avgSpeedInKMH: Float = 0f,
    var distanceInMeter: Int = 0,
    var timeInMillis: Long = 0L
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}