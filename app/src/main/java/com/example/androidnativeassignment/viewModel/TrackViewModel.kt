package com.example.androidnativeassignment.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidnativeassignment.db.Track
import com.example.androidnativeassignment.repository.TrackRepository
import com.example.androidnativeassignment.utils.SortType
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject


class TrackViewModel @ViewModelInject constructor(
    val trackRepository : TrackRepository
) : ViewModel(){

    private val tracksSortedByDate = trackRepository.getAllTracksSortedByDate()
    private val tracksSortedByDistance = trackRepository.getAllTracksSortedByDistance()
    private val tracksSortedByTimeInMillis = trackRepository.getAllTracksSortedByTimeInMillis()

    val tracks = MediatorLiveData<List<Track>>()

    var sortType = SortType.DATE

    /**
     * Posts the correct run list in the LiveData
     */
    init {
        tracks.addSource(tracksSortedByDate) { result ->
            if(sortType == SortType.DATE) {
                result?.let { tracks.value = it }
            }
        }
        tracks.addSource(tracksSortedByDistance) { result ->
            if(sortType == SortType.DISTANCE) {
                result?.let { tracks.value = it }
            }
        }
        tracks.addSource(tracksSortedByTimeInMillis) { result ->
            if(sortType == SortType.RUNNING_TIME) {
                result?.let { tracks.value = it }
            }
        }
    }

    fun sortTracks(sortType: SortType) = when(sortType) {
        SortType.DATE -> tracksSortedByDate.value?.let { tracks.value = it }
        SortType.DISTANCE -> tracksSortedByDistance.value?.let { tracks.value = it }
        SortType.RUNNING_TIME -> tracksSortedByTimeInMillis.value?.let { tracks.value = it }
    }.also {
        this.sortType = sortType
    }

    fun insertTracks(track: Track) = viewModelScope.launch {
        trackRepository.insertTrack(track)
    }

    fun deleteTracks(track: Track) = viewModelScope.launch {
        trackRepository.deleteTrack(track)
    }
}