package com.example.munchmate.bottomFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.munchmate.R
import com.example.munchmate.adapters.MenuAdapter
import com.example.munchmate.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuFoodPrice = mutableListOf<String>()
    private val filterMenuFoodImage = mutableListOf<Int>()

    private lateinit var adapter: MenuAdapter

    private var foodName = listOf("Burger", "Sandwich", "Momo", "List", "Items, banner","offer","see")
    private var price = listOf("350", "170", "150", "5", "15","34","50","678")
    private var popularFoodImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         foodName = listOf("Burger", "Sandwich", "Momo", "List", "Items, banner","offer","see")
         price = listOf("350", "170", "150", "5", "15","34","50","678")
         popularFoodImage = mutableListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        )

        adapter =
            MenuAdapter(filterMenuFoodName, filterMenuFoodPrice, filterMenuFoodImage, requireFragmentManager())
        binding.menuRecView.adapter = adapter
        binding.menuRecView.layoutManager = LinearLayoutManager(requireContext())

        searchViewBox()
        showAllItems()
    }

    private fun showAllItems() {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        filterMenuFoodName.addAll(foodName)
        filterMenuFoodPrice.addAll(price)
        filterMenuFoodImage.addAll(popularFoodImage)
    }

    private fun searchViewBox() {
        binding.searchBox.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        foodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = false)){
                filterMenuFoodName.add(foodName)
                filterMenuFoodPrice.add(price[index])
                filterMenuFoodImage.add(popularFoodImage[index])
            }
        }
       adapter.notifyDataSetChanged()
    }
}