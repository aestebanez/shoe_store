package com.example.shoe_store.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentShoeListBinding
import com.example.shoe_store.model.Shoe


class ShoeListFragment : Fragment() {


    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes?.let {
                displayShoes(it)
            }
        })


        binding.buttonAddShoe.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }


        return binding.root
    }

    private fun displayShoe(shoe: Shoe) {

    }

    private fun displayShoes(shoes: List<Shoe>){
        shoes.forEach { displayShoe(it) }
    }


}