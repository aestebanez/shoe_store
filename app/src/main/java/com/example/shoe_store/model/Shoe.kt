package com.example.shoe_store.model


data class Shoe (
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
)

