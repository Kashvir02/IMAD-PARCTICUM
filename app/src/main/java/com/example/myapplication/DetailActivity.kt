package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailedInventory = findViewById<TextView>(R.id.tvDetailedInventory)
        val btnBackToBase = findViewById<Button>(R.id.btnBackToBase)

        // Retrieve data from Intent
        val names = intent.getStringArrayExtra("itemNames") ?: arrayOf()
        val categories = intent.getStringArrayExtra("itemCategories") ?: arrayOf()
        val quantities = intent.getIntArrayExtra("itemQuantities") ?: intArrayOf()
        val comments = intent.getStringArrayExtra("itemComments") ?: arrayOf()

        // Build detailed display using a loop
        var displayString = ""
        for (i in names.indices) {
            displayString += "🏕️ ITEM ${i + 1}\n" +
                             "Name: ${names[i]}\n" +
                             "Category: ${categories[i]}\n" +
                             "Quantity: ${quantities[i]}\n" +
                             "Notes: ${comments[i]}\n" +
                             "---------------------------\n\n"
        }

        if (displayString.isEmpty()) {
            displayString = "Inventory is empty. Go back and add some gear!"
        }

        tvDetailedInventory.text = displayString

        btnBackToBase.setOnClickListener {
            finish() // Return to the previous screen
        }
    }
}