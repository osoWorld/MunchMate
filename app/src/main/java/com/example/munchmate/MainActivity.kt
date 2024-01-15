package com.example.munchmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.munchmate.Fragments.NotificationBottomSheetFragment
import com.example.munchmate.bottomFragment.CartFragment
import com.example.munchmate.bottomFragment.HistoryFragment
import com.example.munchmate.bottomFragment.HomeFragment
import com.example.munchmate.bottomFragment.ProfileFragment
import com.example.munchmate.bottomFragment.SearchFragment
import com.example.munchmate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> replaceFragment(HomeFragment())
                R.id.cart_menu -> replaceFragment(CartFragment())
                R.id.search_menu -> replaceFragment(SearchFragment())
                R.id.history_menu -> replaceFragment(HistoryFragment())
                R.id.profile_menu -> replaceFragment(ProfileFragment())

                else -> {}
            }
            true
        }

        binding.notificationBell.setOnClickListener {
            val bottomSheetDialog = NotificationBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager,"Notifi")
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}