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
import com.example.shoe_store.databinding.FragmentShoeListBinding
import com.example.shoe_store.databinding.SingleShoeBinding
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
            Log.i("ShoeListFragment","Listener buttonAddShoe")
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun displayShoe(shoe: Shoe) {
        val listSingleShoeBinding: SingleShoeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.single_shoe, null, false)
        Log.i("ShoeListFragment", "displayShoe")
        Log.i("ShoeListFragment", shoe.name)
        listSingleShoeBinding.textShoeName.text = StringBuilder(listSingleShoeBinding.textShoeName.text).append(shoe.name).toString()
        listSingleShoeBinding.texShoeBrand.text = StringBuilder(listSingleShoeBinding.texShoeBrand.text).append(shoe.brand).toString()
        listSingleShoeBinding.textShoeSize.text = StringBuilder(listSingleShoeBinding.textShoeSize.text).append(shoe.size).toString()
        listSingleShoeBinding.textShoeDescription.text = StringBuilder(listSingleShoeBinding.textShoeDescription.text).append(shoe.description).toString()

        binding.linearLayoutListShoes.addView(listSingleShoeBinding.root)
    }

    private fun displayShoes(shoes: List<Shoe>){
        shoes.forEach { displayShoe(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}
