package com.example.munchmate.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.munchmate.activities.FoodItemsActivity
import com.example.munchmate.databinding.PopularRecItemsBinding

class PopularAdapter(
    private val items: List<String>,
    private val image: List<Int>,
    private val price: List<String>,
    val context: Context
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    class PopularViewHolder(var binding: PopularRecItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, price: String, images: Int) {
            binding.recTitle.text = item
            binding.recPrice.text = price
            binding.recImage.setImageResource(images)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularRecItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val prices = price[position]

        holder.bind(item, prices, images)
        holder.binding.popularCard.setOnClickListener {
            context.startActivity(Intent(context,FoodItemsActivity::class.java))
        }

    }
}