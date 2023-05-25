package com.example.android.assignment6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val savory = ArrayList<String>()
    private val sweet = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val savoryrecipies = findViewById<RecyclerView>(R.id.savoryrecipies)
        val sweetrecipies = findViewById<RecyclerView>(R.id.sweetrecipies)
        val savorybutton = findViewById<Button>(R.id.savory)
        val sweetbutton = findViewById<Button>(R.id.sweet)
        val name = findViewById<TextInputEditText>(R.id.name)
        val description = findViewById<TextInputEditText>(R.id.description)
        savorybutton.setOnClickListener{
            sweet.add(name.text.toString())
            name.setText("")
            description.setText("")
            savoryrecipies.adapter = CustomAdapter(sweet)
            savoryrecipies.layoutManager = LinearLayoutManager(applicationContext)
        }
        sweetbutton.setOnClickListener{
            sweet.add(name.text.toString())
            name.setText("")
            description.setText("")
            sweetrecipies.adapter = CustomAdapter(sweet)
            sweetrecipies.layoutManager = LinearLayoutManager(applicationContext)
        }
    }
}

internal class CustomAdapter(private var itemsList: List<String>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}