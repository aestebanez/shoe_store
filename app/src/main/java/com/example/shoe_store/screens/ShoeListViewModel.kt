package com.example.shoe_store.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoe_store.model.Shoe



class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() =_shoes

    private val _shoeSaved = MutableLiveData<Boolean>()
    val shoeSaved: LiveData<Boolean>
        get() = _shoeSaved

    var currentShoe: Shoe? = null

    fun createNewShoe(){
        currentShoe = Shoe("", 1,"","")
    }

    fun saveShoe(){
        val tempShoes = mutableListOf<Shoe>()

        _shoes.value?.let {
            tempShoes.addAll(it)
        }

        currentShoe?.let {
            tempShoes.add(it)
        }
        _shoes.value = tempShoes
        _shoeSaved.value = true

    }
}

