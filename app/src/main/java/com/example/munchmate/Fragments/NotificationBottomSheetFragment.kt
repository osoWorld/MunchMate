package com.example.munchmate.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.munchmate.R
import com.example.munchmate.adapters.MenuAdapter
import com.example.munchmate.adapters.NotificationAdapter
import com.example.munchmate.databinding.FragmentNotificationBottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottonSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottonSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodName = listOf(
            "Your order has been Canceled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed",
            "Your order has been Canceled Successfully",
            "Order has been taken by the driver",
            " Congrats Your Order Placed"
        )
        val popularFoodImage = listOf(
            R.drawable.sademoji,
            R.drawable.truck,
            R.drawable.congrats,
            R.drawable.sademoji,
            R.drawable.truck,
            R.drawable.congrats,
        )

        val adapter =
            NotificationAdapter(ArrayList(foodName), ArrayList(popularFoodImage))
        binding.notificationRecView.adapter = adapter
        binding.notificationRecView.layoutManager = LinearLayoutManager(requireContext())
    }
}