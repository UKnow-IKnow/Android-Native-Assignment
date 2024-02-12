package com.example.androidnativeassignment.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.androidnativeassignment.repository.TrackRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


class TrackViewModel @ViewModelInject constructor(
    val trackRepository : TrackRepository
) : ViewModel(){
}