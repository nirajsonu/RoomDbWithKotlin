package com.example.roomdbwithkotlin.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdbwithkotlin.R
import java.util.*

class LifeCycleActivity : AppCompatActivity() {

    val TAG=LifeCycleActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        Log.d(TAG, "Activity onCreate called ")


        lifecycle.addObserver(MyLifeCycleObserver())

    }
}