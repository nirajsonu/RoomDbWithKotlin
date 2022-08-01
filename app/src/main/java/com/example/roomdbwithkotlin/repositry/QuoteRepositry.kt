package com.example.roomdbwithkotlin.repositry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomdbwithkotlin.database.MyDatabase
import com.example.roomdbwithkotlin.model.QuoteModel
import com.example.roomdbwithkotlin.retrofit.QuoteService

class QuoteRepositry(private val quoteService: QuoteService,private val myRoomDatabase: MyDatabase) {

    private val quoteListData=MutableLiveData<QuoteModel>()

    val quotes:LiveData<QuoteModel>
    get() = quoteListData

    suspend fun getQuotes(page:Int){
        val result=quoteService.getQuotes(page)
        if(result?.body()!=null){
            myRoomDatabase.quoteDao().addQuotes(result.body()!!.results)
            quoteListData.postValue(result.body())
        }
    }



}