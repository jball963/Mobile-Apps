package com.example.android.finalproject

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SubMenuActivity : AppCompatActivity() {

    private lateinit var submenuTitleTextView: TextView
    private lateinit var foodGridView: GridView
    private lateinit var selectedFoodTextView: TextView
    private lateinit var selectedFoodImageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submenu)

        submenuTitleTextView = findViewById(R.id.submenu_title)
        foodGridView = findViewById(R.id.food_grid)
        selectedFoodTextView = findViewById(R.id.selected_food)
        selectedFoodImageView = findViewById(R.id.selected_food_image)
        backButton = findViewById(R.id.back_button)

        val submenuTitle = intent.getStringExtra("submenu_title")
        submenuTitleTextView.text = submenuTitle

        val foodItems = listOf(
            FoodItem("Burger", R.drawable.burber),
            FoodItem("Salmon", R.drawable.salmon),
            FoodItem("Curry", R.drawable.curry),
            FoodItem("Eggs", R.drawable.eggs)
        )

        val foodAdapter = FoodAdapter(this, foodItems)
        foodGridView.adapter = foodAdapter

        foodGridView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedFood = foodItems[position]
                selectedFoodTextView.text = "Selected Food: ${selectedFood.name}"
                selectedFoodImageView.setImageResource(selectedFood.imageResId)
            }

        backButton.setOnClickListener {
            finish()
        }
    }
}
