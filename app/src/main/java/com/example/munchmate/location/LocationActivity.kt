package com.example.munchmate.location

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListPopupWindow
import com.example.munchmate.MainActivity
import com.example.munchmate.R
import com.example.munchmate.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationList = arrayOf("Faisalabad","Lahore","Islamabad","Peshawar", "Quetta","Karachi")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)

        binding.listOfLocation.setAdapter(adapter)

        binding.confirmLocationButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}