package com.company.mindcare

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.company.mindcare.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listeners for the buttons
        binding.manualButton.setOnClickListener {
            val intent = Intent(this, Manual::class.java)
            startActivity(intent)
        }

        binding.chatbotButton.setOnClickListener {
            val intent = Intent(this, Chatbot::class.java)
            startActivity(intent)

        }

        binding.helplineButton.setOnClickListener {
            val intent = Intent(this, Helpline::class.java)
            startActivity(intent)
        }

    }

}