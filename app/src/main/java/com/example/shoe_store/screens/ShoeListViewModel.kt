package com.example.shoe_store.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoe_store.model.Shoe

class ShoeListViewModel : ViewModel() {
    var shoeList = MutableLiveData<List<Shoe>>()


    fun addShoe(curShoe : Shoe){

    }
}