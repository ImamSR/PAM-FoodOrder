package com.example.projectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val idUser = intent.getStringExtra("Nama")
        val location = intent.getStringExtra("Location")

        val idUserTextView = findViewById<TextView>(R.id.PersonId)
        val getLokasi = findViewById<TextView>(R.id.locationShow)

        idUserTextView.text = "Hello , $idUser"
        getLokasi.text = location

        val btnSeeMenus = findViewById<Button>(R.id.btnMenu)
        btnSeeMenus?.setOnClickListener {
            val intent = Intent(this, page3::class.java)
            intent.putExtra("USER_ID", idUser)
            intent.putExtra("STORE_LOCATION", location)
            startActivity(intent)
        }
    }
}
