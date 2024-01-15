package com.example.munchmate.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.munchmate.R
import com.example.munchmate.databinding.ActivityPlaceOrderBinding

class PlaceOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaceOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeOrderButton.setOnClickListener {
            startActivity(Intent(this,CongratulationsActivity::class.java))
        }
    }
}