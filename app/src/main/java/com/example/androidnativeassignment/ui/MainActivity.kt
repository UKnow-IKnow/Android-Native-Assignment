package com.example.androidnativeassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidnativeassignment.R
import com.example.androidnativeassignment.databinding.ActivityMainBinding
import com.example.androidnativeassignment.utils.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToTrackingFragmentIfNeeded(intent)

        setSupportActionBar(binding.toolbar)
        binding.bottomNavigationView.setupWithNavController(binding.navHostFragment.findNavController())

        binding.navHostFragment.findNavController()
            .addOnDestinationChangedListener{ _, destinaton, _ ->
                when(destinaton.id){
                    R.id.profileFragment, R.id.infoFragment ->
                        binding.bottomNavigationView.visibility = View.VISIBLE
                    else -> binding.bottomNavigationView.visibility = View.GONE
                }
            }
    }

    //Checks if we launched the activity from the notification
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?) {
        if(intent?.action == ACTION_SHOW_TRACKING_FRAGMENT) {
            binding.navHostFragment.findNavController().navigate(R.id.action_global_trackingFragment)
        }
    }
}