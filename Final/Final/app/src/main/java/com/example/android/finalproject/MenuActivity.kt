package com.example.android.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var menuListView: ListView
    private lateinit var menuAdapter: MenuAdapter

    private val menuItems = listOf(
        MenuItem("Breakfast", R.drawable.breakfeast),
        MenuItem("Lunch", R.drawable.lunch),
        MenuItem("Dinner", R.drawable.dinner),
        MenuItem("Desserts", R.drawable.desert),
        MenuItem("My Order", R.drawable.orderlist)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        menuListView = findViewById(R.id.menu_list)
        menuAdapter = MenuAdapter(this@MenuActivity, menuItems)
        menuListView.adapter = menuAdapter

        menuListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedItem = menuItems[position]
                when (position) {
                    0 -> openSubMenu("Breakfast")
                    1 -> openSubMenu("Lunch")
                    2 -> openSubMenu("Dinner")
                    3 -> openSubMenu("Desserts")
                    4 -> openMyOrder()
                }
            }
    }

    private fun openSubMenu(submenuTitle: String) {
        val intent = Intent(this, SubMenuActivity::class.java)
        intent.putExtra("submenu_title", submenuTitle)
        startActivity(intent)
    }

    private fun openMyOrder() {
        val intent = Intent(this, Order::class.java)
        startActivity(intent)
    }
}
