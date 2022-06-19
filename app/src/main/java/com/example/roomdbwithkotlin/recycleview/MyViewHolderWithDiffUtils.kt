package com.example.roomdbwithkotlin.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.model.Student
import org.w3c.dom.Text

class MyViewHolderWithDiffUtils:ListAdapter<Student,MyViewHolderWithDiffUtils.StudentViewHolder>(DiffUtil()){

    class DiffUtil:androidx.recyclerview.widget.DiffUtil.ItemCallback<Student>(){
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }

    }


    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view){
        val id=view.findViewById<TextView>(R.id.id_value_txt)
        fun bind(item: Student){
            id.text=item.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_data_show,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }
}