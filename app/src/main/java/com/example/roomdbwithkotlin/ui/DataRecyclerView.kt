package com.example.roomdbwithkotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.model.Result

class DataRecyclerView(context:Context, val datalist:ArrayList<Result>): RecyclerView.Adapter<DataRecyclerView.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val id=itemView.findViewById<TextView>(R.id.id_value_txt)
        val rollNo=itemView.findViewById<TextView>(R.id.roll_number_value)
        val name=itemView.findViewById<TextView>(R.id.name_value)
        val date=itemView.findViewById<TextView>(R.id.date_value)
        val present=itemView.findViewById<TextView>(R.id.present_value_txt)

        fun bind(item:Result){
            id.text=item._id
            rollNo.text=item.authorSlug
            name.text=item.author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataRecyclerView.ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_data_show,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataRecyclerView.ViewHolder, position: Int) {
        holder.bind(datalist.get(position))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


}
