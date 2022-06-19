package com.example.roomdbwithkotlin.firebase.firestore

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.databinding.ActivityInsertDataBinding
import com.example.roomdbwithkotlin.firebase.firestore.model.Employee
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityInsertData : AppCompatActivity() {

    private val personCollectionRef= Firebase.firestore.collection("persons")
    lateinit var binding:ActivityInsertDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SaveDataBtn.setOnClickListener {
            val employee=Employee(binding.nameTxt.text.toString(),binding.cityTxt.text.toString(),binding.positionTxt.text.toString())
            savePerson(employee)
        }




    }

    private fun savePerson(employee: Employee)= CoroutineScope(Dispatchers.IO).launch {
        try{
            personCollectionRef.add(employee)
            withContext(Dispatchers.Main){
                Toast.makeText(this@ActivityInsertData,"Successfully save data..",Toast.LENGTH_LONG).show()
            }
        }catch (e:Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@ActivityInsertData,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }
}