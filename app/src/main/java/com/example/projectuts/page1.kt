package com.example.projectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class page1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page1)

        val spinner: Spinner = findViewById(R.id.spinnertextid)
        ArrayAdapter.createFromResource(
            this,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val btnSubmit = findViewById<Button>(R.id.buttonID)
        btnSubmit?.setOnClickListener(View.OnClickListener{
            val selectedLocation = spinner.selectedItem.toString()

            val nameInput = findViewById<EditText>(R.id.address_text).text.toString()

            val intent = Intent(this, page2::class.java)

            intent.putExtra("Location", selectedLocation)
            intent.putExtra("Nama", nameInput)
            startActivity(intent)
        })
    }
}
