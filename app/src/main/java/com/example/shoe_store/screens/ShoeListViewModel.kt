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

    fun onEventSavedShoe(){
        _shoeSaved.value = null
    }

    var curShoe: Shoe? = null

    fun createNewShoe(){
        curShoe = Shoe("", 1,"","")
    }

    fun saveShoe(){
        val tempShoes = mutableListOf<Shoe>()

        _shoes.value?.let {
            tempShoes.addAll(it)
        }

        curShoe?.let {
            tempShoes.add(it)
        }
        _shoes.value = tempShoes
        _shoeSaved.value = true

    }
}

