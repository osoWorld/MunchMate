package com.example.munchmate.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.munchmate.MainActivity
import com.example.munchmate.R
import com.example.munchmate.databinding.ActivityCongratulationsBinding

class CongratulationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCongratulationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doneAnim.playAnimation()

        binding.goHomeButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}