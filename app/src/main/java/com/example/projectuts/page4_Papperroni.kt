package com.example.projectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page4_Papperroni : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page4_papperroni)
        val userId = intent.getStringExtra("USER_ID")
        val storeSTORE_LOCATION = intent.getStringExtra("STORE_LOCATION")

        val selectedFood = intent.getStringExtra("FOOD_NAME")

        val orderButton = findViewById<Button>(R.id.OrderIdBtn)
        orderButton.setOnClickListener {
            val intent = Intent(this, ExecutionOrder::class.java)
            intent.putExtra("SELECTED_FOOD", selectedFood)
            intent.putExtra("USER_ID",userId)
            intent.putExtra("STORE_LOCATION",storeSTORE_LOCATION)
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.BackIdBtn)
        backButton.setOnClickListener {
            val intent = Intent(this, page3::class.java)
            intent.putExtra("USER_ID",userId)
            startActivity(intent)
        }
    }
}