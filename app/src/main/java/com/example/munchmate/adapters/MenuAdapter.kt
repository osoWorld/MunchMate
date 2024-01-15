package com.example.munchmate.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.munchmate.Fragments.ItemsBottomSheetFragment
import com.example.munchmate.activities.PlaceOrderActivity
import com.example.munchmate.databinding.PopularRecItemsBinding

class MenuAdapter(
    private val menuItems: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private val menuItemImages: MutableList<Int>,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val binding: PopularRecItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int){
                binding.apply {
                    recTitle.text = menuItems[position]
                    recPrice.text = menuItemPrice[position]
                    recImage.setImageResource(menuItemImages[position])
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            PopularRecItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("imageData",menuItemImages[position])
                putString("nameData",menuItems[position])
            }
            val itemBottomSheet = ItemsBottomSheetFragment()
            itemBottomSheet.show(fragmentManager,"items")
            itemBottomSheet.arguments = bundle
        }
    }
}