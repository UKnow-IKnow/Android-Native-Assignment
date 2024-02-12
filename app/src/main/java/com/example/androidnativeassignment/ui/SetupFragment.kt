package com.example.androidnativeassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidnativeassignment.R
import com.example.androidnativeassignment.databinding.FragmentSetupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetupFragment : Fragment() {

    private var _binding:FragmentSetupBinding? = null;
    private val binding get() = _binding!!;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentSetupBinding.inflate(inflater,container,false);


        binding.tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_setupFragment_to_infoFragment2)
        }

        return binding.root;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}