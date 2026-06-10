package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Parallel arrays to store data, initialized with sample data
    private var itemNames = arrayOf("Tent", "Marshmallows")
    private var itemCategories = arrayOf("Shelter", "Food")
    private var itemQuantities = arrayOf(1, 3)
    private var itemComments = arrayOf("4 person waterproof", "For s'mores")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etItemName = findViewById<EditText>(R.id.etItemName)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etComments = findViewById<EditText>(R.id.etComments)
        val btnAddGear = findViewById<Button>(R.id.btnAddGear)
        val btnViewDetails = findViewById<Button>(R.id.btnViewDetails)
        val tvTotalItems = findViewById<TextView>(R.id.tvTotalItems)
        val tvChecklist = findViewById<TextView>(R.id.tvChecklist)



        btnAddGear.setOnClickListener {
            val name = etItemName.text.toString()
            val category = etCategory.text.toString()
            val quantityStr = etQuantity.text.toString()
            val comments = etComments.text.toString()

            if (name.isNotEmpty() && category.isNotEmpty() && quantityStr.isNotEmpty()) {
                val quantity = try {
                    quantityStr.toInt()
                } catch (e: NumberFormatException) {
                    0
                }


                itemNames += name
                itemCategories += category
                itemQuantities += quantity
                itemComments += comments


                etItemName.text.clear()
                etCategory.text.clear()
                etQuantity.text.clear()
                etComments.text.clear()


                updateUI(tvTotalItems, tvChecklist)
                Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            }
        }


        btnViewDetails.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            // Passing parallel arrays to DetailActivity
            intent.putExtra("itemNames", itemNames)
            intent.putExtra("itemCategories", itemCategories)
            intent.putExtra("itemQuantities", itemQuantities.toIntArray())
            intent.putExtra("itemComments", itemComments)
            startActivity(intent)
        }
    }

    private fun updateUI(tvTotal: TextView, tvChecklist: TextView) {
        var totalQuantity = 0
        var checklistSummary = "Quick Checklist:\n"

        // Use a loop to iterate through parallel arrays
        for (i in itemNames.indices) {
            totalQuantity += itemQuantities[i]
            checklistSummary += "• ${itemNames[i]} (${itemQuantities[i]})\n"
        }

        tvTotal.text = "Total Items Packed: $totalQuantity"
        tvChecklist.text = checklistSummary
    }
}
/*
Author : W3schools
Date published : None
Date accessessd: 10 june 2026
url: https://www.w3schools.com/kotlin/kotlin_conditions.php
 */

/*
Author : Manish cumar
date published :june 26 2025
Date accessessd: 10 june 2026
Url: https://medium.com/@manishkumar_75473/building-a-splash-screen-in-android-the-right-way-2025-edition-084683381283
 */

/*
Author:kotlinlang.org
Date published : 24th march 2026
Date acessesd: 10 june 2027
Url: https://kotlinlang.org/docs/multiplatform/compose-navigation-routing.html
 */