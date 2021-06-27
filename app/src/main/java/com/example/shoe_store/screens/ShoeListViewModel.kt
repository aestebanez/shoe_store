package com.example.shoe_store.screens

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoe_store.model.Shoe
import com.google.android.material.internal.ContextUtils.getActivity
import java.security.AccessController.getContext


class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() =_shoes

    private val _shoeSaved = MutableLiveData<Boolean?>()
    val shoeSaved: MutableLiveData<Boolean?>
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
        Log.i("ShoeListViewModel", "saveShoe()")
        Log.i("ShoeListViewModel", "curShoe:"+(curShoe?.name))
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

