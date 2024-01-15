package com.example.munchmate.bottomFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.munchmate.R
import com.example.munchmate.adapters.CartAdapter
import com.example.munchmate.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodName = listOf("Burger", "Sandwich", "Momo", "List", "Items, banner","offer","see")
        val price = listOf("350", "170", "150", "5", "15","34","50","678")
        val popularFoodImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        )

        val adapter =
            CartAdapter(ArrayList(foodName), ArrayList(price), ArrayList(popularFoodImage))
        binding.cartRecView.adapter = adapter
        binding.cartRecView.layoutManager = LinearLayoutManager(requireContext())
    }
}