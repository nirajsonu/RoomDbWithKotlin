package com.example.roomdbwithkotlin.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.application.QuoteApplication
import com.example.roomdbwithkotlin.databinding.ActivityDataBindingBinding
import com.example.roomdbwithkotlin.factory.MyViewModelFactory

class DataBindingActivity : AppCompatActivity() {

    lateinit var binding:ActivityDataBindingBinding
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val repositry=(application as QuoteApplication).quoteRepositry

        binding=DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        viewModel=ViewModelProvider(this, MyViewModelFactory(repositry)).get(MyViewModel::class.java)


        binding.lifecycleOwner=this
        binding.viewmodel=viewModel


    }
}