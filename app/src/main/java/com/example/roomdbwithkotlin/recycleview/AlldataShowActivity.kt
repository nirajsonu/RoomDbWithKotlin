package com.example.roomdbwithkotlin.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.database.MyRoomDB
import com.example.roomdbwithkotlin.databinding.ActivityAlldataShowBinding
import com.example.roomdbwithkotlin.model.Student
import com.example.roomdbwithkotlin.viewmodel.MyViewModel
import java.util.*
import kotlin.collections.ArrayList

class AlldataShowActivity : AppCompatActivity(),OnClickListnear{
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyHolderWithoutDiffUtils
    lateinit var binding:ActivityAlldataShowBinding
    lateinit var student0: Student
    lateinit var student1: Student
    lateinit var student2: Student
    lateinit var viewModel:ViewModel
    lateinit var arrayList: ArrayList<Student>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_alldata_show)



        viewModel=ViewModelProvider(this).get(MyViewModel::class.java)
        binding= ActivityAlldataShowBinding.inflate(layoutInflater)



        val root=binding.root
        setContentView(root)

        val l= listOf<Int>(1,2,3,4,5,6,7,8)



      /*  student0= Student(1,"Neeraj kumar Keshri","12", Date(),1,"Noida")
        student1= Student(2,"Sonu kumar","10", Date(),1,"Ranchi")
        student2= Student(3,"Neeraj kumar Keshri","15", Date(),1,"Kolkata")*/

        arrayList= ArrayList();
        arrayList.add(Student(10,"Neeraj","18",Date(),1,"Agra"))


        adapter= MyHolderWithoutDiffUtils(applicationContext,arrayList)

    //    adapter.submitList(listOf(student0,student1,student2))
        binding.roomRecycleviewData.layoutManager= LinearLayoutManager(this)
        binding.roomRecycleviewData.hasFixedSize()
        binding.roomRecycleviewData.adapter=adapter

    }

    override fun itemClick() {
        Toast.makeText(applicationContext,"interface clicked",Toast.LENGTH_LONG).show()
    }


}