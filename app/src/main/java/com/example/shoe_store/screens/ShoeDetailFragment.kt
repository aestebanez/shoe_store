package com.example.shoe_store.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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
        Log.i("ShoeDetailFragment", "entered onCreateView after createNewShoe")



        viewModel.shoeSaved.observe(viewLifecycleOwner, Observer { shoeSaved ->
            shoeSaved?.let {
                Log.i("ShoeDetailFragment", "entered shoeSaver observer")
                if (it) {
                    findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
                    viewModel.onEventSavedShoe()
                }
            }

        })
        Log.i("ShoeDetailFragment", "passed shoeSaver observer")
        binding.buttonSave.setOnClickListener {
            Log.i("ShoeDetailFragment", "entered buttonSave onClickListener")
            viewModel.curShoe!!.name  = binding.editTextName.text.toString()
            viewModel.curShoe!!.brand  = binding.editTextBrand.text.toString()
            viewModel.curShoe!!.size  = binding.editTextSize.text.toString().toInt()
            viewModel.curShoe!!.description  = binding.editTextDescription.text.toString()
            viewModel.saveShoe()
        }



//        setHasOptionsMenu(true)
        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.overflow_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }



}