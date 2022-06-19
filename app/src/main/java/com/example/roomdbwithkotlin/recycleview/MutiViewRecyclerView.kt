package com.example.roomdbwithkotlin.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithkotlin.databinding.ActivityMutiViewRecyclerViewBinding
import com.example.roomdbwithkotlin.model.MutiViewModel

class MutiViewRecyclerView : AppCompatActivity() {

    lateinit var binding:ActivityMutiViewRecyclerViewBinding
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMutiViewRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataList=ArrayList<MutiViewModel>()

        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_ONE,"Hi this is 1st view"))
        dataList.add(MutiViewModel(MyViewHolderWithMultiView.VIEW_TYPE_TWO,"Hi this is 2nd view"))


        val myadapter=MyViewHolderWithMultiView(applicationContext,dataList)


        var arrayOfElements=intArrayOf(1,12,4,3,20,6)




        linearLayoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        binding.recyclerview.apply {
            layoutManager=linearLayoutManager
            adapter=myadapter

        }


        

        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            
            
           

            var firstVisibleInListview=linearLayoutManager.findFirstVisibleItemPosition()



            /*override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentVisisbleItem=linearLayoutManager.findFirstVisibleItemPosition()
                if(currentVisisbleItem>firstVisibleInListview){
                    Toast.makeText(applicationContext,"Scroll up",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(applicationContext,"Scroll Down",Toast.LENGTH_LONG).show()
                }
                firstVisibleInListview = currentVisisbleItem
            }*/
        })

    }




}