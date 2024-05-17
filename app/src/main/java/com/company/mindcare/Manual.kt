package com.company.mindcare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.company.mindcare.databinding.ActivityManualBinding


class Manual : AppCompatActivity() {

    private lateinit var binding: ActivityManualBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManualBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the content view to the root view of the binding

        // Set up click listeners for the buttons
        binding.cdepressionButton.setOnClickListener {
            val intent = Intent(this, ClinicalDep::class.java)
            Log.d("ButtonClick", "Button clicked")
            startActivity(intent)
            Log.d("ButtonClick", "Started activity")
        }

        binding.anxietyButton.setOnClickListener {
            val intent = Intent(this, Anxiety::class.java)
            startActivity(intent)
        }

        binding.bipolarButton.setOnClickListener {
            val intent = Intent(this, Bipolar::class.java)
            startActivity(intent)
        }

        binding.schizoButton.setOnClickListener {
            val intent = Intent(this, Schizo::class.java)
            startActivity(intent)
        }
    }
}