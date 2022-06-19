package com.example.roomdbwithkotlin.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbwithkotlin.repositry.QuoteRepositry
import com.example.roomdbwithkotlin.viewmodel.MyViewModel

class MyViewModelFactory(private val repositry: QuoteRepositry):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyViewModel(repositry) as T
    }
}