package com.example.android.lecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.lecture.Contact

data class Contact(val title:String, val number:Int)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}