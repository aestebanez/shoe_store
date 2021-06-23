package com.example.shoe_store.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        Toast.makeText(requireActivity(),binding.buttonLogin.text, Toast.LENGTH_LONG).show()


        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_welcome)
        }
        binding.buttonSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_welcome)
        }
        return binding.root
    }
}