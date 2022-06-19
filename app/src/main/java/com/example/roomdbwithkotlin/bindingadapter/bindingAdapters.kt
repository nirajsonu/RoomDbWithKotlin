package com.example.roomdbwithkotlin.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomdbwithkotlin.model.Result
import com.example.roomdbwithkotlin.ui.DataRecyclerView

@BindingAdapter("bindlist")
fun bindRecyclerView(view:RecyclerView,datalist:ArrayList<Result>){
    if(datalist.isEmpty()){
        return
    }

    val layoutManager=view.layoutManager
    if(layoutManager==null)
        view.layoutManager=GridLayoutManager(view.context,2)

    var adapter=view.adapter
    if(adapter==null){
        adapter=DataRecyclerView(view.context,datalist)
        view.adapter=adapter
    }
}




@BindingAdapter("loadImageFromUrl")
fun ImageView.setUrl(url:String){
Glide.with(this.context).load(url).load(this)
}