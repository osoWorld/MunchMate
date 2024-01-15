package com.example.munchmate.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.munchmate.R
import com.example.munchmate.databinding.FragmentItemsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemsBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentItemsBottomSheetBinding
    private var foodItemImage: Int? = null
    private var foodItemName: String? = null
    private var itemQuantity: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bundle = arguments

        if (bundle != null) {
            foodItemImage = bundle.getInt("imageData", 0)
            foodItemName = bundle.getString("nameData")
        }

        binding = FragmentItemsBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            if (foodItemImage!= null){
                foodMainImage.setImageResource(foodItemImage!!)
                foodName.text = foodItemName
            }
            else{
                Toast.makeText(requireContext(), "Null", Toast.LENGTH_SHORT).show()
            }
            plusBtn.setOnClickListener {
                increaseQuantity()
            }
            minusBtn.setOnClickListener {
                decreaseQuantity()
            }
        }

    }

    private fun decreaseQuantity() {
        if (itemQuantity > 1) {
            itemQuantity--

            binding.foodQuantityText.text = itemQuantity.toString()
        }
    }

    private fun increaseQuantity() {
        if (itemQuantity < 10) {
            itemQuantity++

            binding.foodQuantityText.text = itemQuantity.toString()
        }
    }
}