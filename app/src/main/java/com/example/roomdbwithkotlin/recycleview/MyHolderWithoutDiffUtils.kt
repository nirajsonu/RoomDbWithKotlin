package com.example.roomdbwithkotlin.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.model.Student

class MyHolderWithoutDiffUtils(context:Context,val studentlist:ArrayList<Student>):RecyclerView.Adapter<MyHolderWithoutDiffUtils.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val id=itemView.findViewById<TextView>(R.id.id_value_txt)
        val rollNo=itemView.findViewById<TextView>(R.id.roll_number_value)
        val name=itemView.findViewById<TextView>(R.id.name_value)
        val date=itemView.findViewById<TextView>(R.id.date_value)
        val present=itemView.findViewById<TextView>(R.id.present_value_txt)


        init{
           // onItemClick.click()
        }

        fun bind(item: Student){
            id.text=item.id.toString()
            rollNo.text=item.roll_nol.toString()
            name.text=item.name.toString()
            date.text=item.createdDate.toString()
            present.text=item.isPresent.toString()

        }



    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolderWithoutDiffUtils.ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_data_show,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyHolderWithoutDiffUtils.ViewHolder, position: Int) {
        holder.bind(studentlist[position])

    }

    override fun getItemCount(): Int {
      return  studentlist.size
    }



}