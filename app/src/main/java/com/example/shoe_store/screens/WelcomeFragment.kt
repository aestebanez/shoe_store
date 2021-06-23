package com.example.shoe_store.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.buttonInstructions.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_instructionsFragment)
        }

        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }


}