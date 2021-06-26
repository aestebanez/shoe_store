package com.example.shoe_store.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel.createNewShoe();

        viewModel.shoeSaved.observe(viewLifecycleOwner, Observer { close ->
            close?.let {
            if (it) {
                findNavController().navigateUp()
                viewModel.onEventSavedShoe()
            }
        }
        })

//        binding.buttonSave.setOnClickListener {
//            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
//        }
        return binding.root
    }



}