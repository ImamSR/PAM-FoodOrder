package com.example.projectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        val fabButton = findViewById<FloatingActionButton>(R.id.fab)

        fabButton.setOnClickListener {
            val userId = intent.getStringExtra("USER_ID")
            val storeLocation = intent.getStringExtra("STORE_LOCATION")

            val foodNames = arrayOf("Pepperoni Pizza", "Spaghetti", "Burger", "Steak")

            for (foodName in foodNames) {
                val intent = Intent(this, when (foodName) {
                    "Pepperoni Pizza" -> page4_Papperroni::class.java
                    "Spaghetti" -> page4_spagetti::class.java
                    "Burger" -> page4_burger::class.java
                    "Steak" -> page4_steak::class.java
                    else -> page4_Papperroni::class.java
                })

                intent.putExtra("FOOD_NAME", foodName)
                intent.putExtra("USER_ID", userId)
                intent.putExtra("STORE_LOCATION", storeLocation)
                startActivity(intent)
            }
        }


        val idUser = intent.getStringExtra("USER_ID")
        val idUserTextView = findViewById<TextView>(R.id.PersonId)
        idUserTextView.text = "Hello , $idUser"
        val storeLocation = intent.getStringExtra("STORE_LOCATION")

        setFoodItemClickListener(R.id.piza, "Pepperoni Pizza", idUser, storeLocation)
        setFoodItemClickListener(R.id.spagetti, "Spaghetti", idUser, storeLocation)
        setFoodItemClickListener(R.id.burger, "Burger", idUser, storeLocation)
        setFoodItemClickListener(R.id.steak, "Steak", idUser, storeLocation)
    }

    private fun setFoodItemClickListener(foodItemId: Int, foodName: String, userId: String?, storeLocation: String?) {
        val foodItemLayout = findViewById<LinearLayout>(foodItemId)

        foodItemLayout.setOnClickListener {
            val intent = Intent(this, when (foodName) {
                "Pepperoni Pizza" -> page4_Papperroni::class.java
                "Spaghetti" -> page4_spagetti::class.java
                "Burger" -> page4_burger::class.java
                "Steak" -> page4_steak::class.java
                else -> page4_Papperroni::class.java
            })

            intent.putExtra("FOOD_NAME", foodName)
            intent.putExtra("USER_ID", userId)
            intent.putExtra("STORE_LOCATION", storeLocation)
            startActivity(intent)
        }
    }
}