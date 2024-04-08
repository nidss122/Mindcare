package com.company.mindcare

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.company.mindcare.databinding.ActivityManualBinding

class Manual : AppCompatActivity() {

    private lateinit var binding: ActivityManualBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityManualBinding.inflate(layoutInflater)

        // Set the content view to the root of the inflated layout
        setContentView(binding.root)

        // Set up click listeners for the buttons
        binding.cdepressionButton.setOnClickListener {
            startActivity(Intent(this, ClinicalDep::class.java))
            finish()
        }

        binding.anxietyButton.setOnClickListener {
            startActivity(Intent(this, anxiety::class.java))
        }

        binding.bipolarButton.setOnClickListener {
            startActivity(Intent(this, Bipolar::class.java))
        }

        binding.schizoButton.setOnClickListener {
            startActivity(Intent(this, Schizo::class.java))
        }
    }
}
