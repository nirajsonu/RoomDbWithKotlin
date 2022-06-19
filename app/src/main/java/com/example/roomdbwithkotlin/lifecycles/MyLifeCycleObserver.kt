package com.example.roomdbwithkotlin.lifecycles

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifeCycleObserver:LifecycleObserver {


//val context: Context? =null
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun onCreate() {
        Log.d("onCreate", "onCreate Invoked from observer")
//        Toast.makeText(context,"Observer called",Toast.LENGTH_LONG).show()
    }
}