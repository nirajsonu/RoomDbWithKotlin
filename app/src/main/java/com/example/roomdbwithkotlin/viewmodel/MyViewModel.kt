package com.example.roomdbwithkotlin.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import com.example.roomdbwithkotlin.model.QuoteModel

import com.example.roomdbwithkotlin.repositry.QuoteRepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Appendable

class MyViewModel(private val repositry: QuoteRepositry): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repositry.getQuotes(1)
        }
    }

    val quotes: LiveData<QuoteModel>
    get() = repositry.quotes

    val data=MutableLiveData("hello")

    var name:String="neeraj"


    fun changePersonName(){
        name="soon"
    }

    fun changeTextName(){
        data.value="World"
    }


}