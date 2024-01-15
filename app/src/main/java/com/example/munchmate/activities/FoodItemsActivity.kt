package com.example.munchmate.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.munchmate.R
import com.example.munchmate.databinding.ActivityFoodItemsBinding

class FoodItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodItemsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}