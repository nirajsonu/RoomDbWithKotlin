package com.example.roomdbwithkotlin.application

import android.app.Application
import com.example.roomdbwithkotlin.database.MyDatabase
import com.example.roomdbwithkotlin.repositry.QuoteRepositry
import com.example.roomdbwithkotlin.retrofit.QuoteService
import com.example.roomdbwithkotlin.retrofit.RetrofitHelper
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class QuoteApplication:Application() {
    lateinit var quoteRepositry: QuoteRepositry


    override fun onCreate() {
        super.onCreate()
        initlization()
    }

    private fun initlization() {
       val quoteService= RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database=MyDatabase.getDatabase(applicationContext)
        quoteRepositry=QuoteRepositry(quoteService,database)
    }
}