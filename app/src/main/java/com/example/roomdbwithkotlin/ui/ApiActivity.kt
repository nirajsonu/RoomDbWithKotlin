package com.example.roomdbwithkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithkotlin.application.QuoteApplication
import com.example.roomdbwithkotlin.databinding.ActivityApiBinding
import com.example.roomdbwithkotlin.factory.MyViewModelFactory
import com.example.roomdbwithkotlin.model.Result
import com.example.roomdbwithkotlin.repositry.QuoteRepositry
import com.example.roomdbwithkotlin.retrofit.QuoteService
import com.example.roomdbwithkotlin.viewmodel.MyViewModel
import kotlin.collections.ArrayList

class ApiActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    lateinit var quoteService: QuoteService
    lateinit var repositry: QuoteRepositry
    var LOG:String=ApiActivity::javaClass.name

    lateinit var recylerView:RecyclerView
    lateinit var binding:ActivityApiBinding
    lateinit var adapter: DataRecyclerView
    lateinit var arrayList: ArrayList<com.example.roomdbwithkotlin.model.Result>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_api)

        binding= ActivityApiBinding.inflate(layoutInflater)
        val root=binding.root

        setContentView(root)



        val repositry=(application as QuoteApplication).quoteRepositry




            //    adapter.submitList(listOf(student0,student1,student2))


        myViewModel=ViewModelProvider(this,MyViewModelFactory(repositry)).get(MyViewModel::class.java)

        myViewModel.quotes.observe(this) {
            Log.d("MyResponse", it.results.toString())
            arrayList= ArrayList();

            for(i in 0 until it.count){
                arrayList.add(Result(it.results.get(i).quoteId,it.results.get(i).author,it.results.get(i).authorSlug,
                    it.results.get(i).content,it.results.get(i).dateAdded,it.results.get(i).dateModified,it.results.get(i).length.toString(),
                    "12".toInt()))
            }
            adapter= DataRecyclerView(applicationContext,arrayList)
            binding.recycleview.layoutManager= LinearLayoutManager(this)
            binding.recycleview.hasFixedSize()
            binding.recycleview.adapter=adapter
        }


    }
}


