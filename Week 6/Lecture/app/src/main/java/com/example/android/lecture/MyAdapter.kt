package com.avionmission.rvpractice3

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.lecture.Contact
import com.example.android.lecture.R

class MyAdapter(val contacts: List<Contact>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder() {
        var contactName = itemView.findViewById<TextView>(R.id.contactName)
        var contactNumber = itemView.findViewById<TextView>(R.id.contactNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}