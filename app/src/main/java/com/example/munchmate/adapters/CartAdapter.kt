package com.example.munchmate.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.munchmate.databinding.CartItemsBinding

class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private val cartItemImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantities = IntArray(cartItems.size) { 1 }

    inner class CartViewHolder(private val binding: CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                recTitle.text = cartItems[position]
                recPrice.text = cartItemPrice[position]
                recImage.setImageResource(cartItemImage[position])
                quantityTV.text = itemQuantities[position].toString()
                minusButton.setOnClickListener {
                    decrease(position)
                }
                plusButton.setOnClickListener {
                    increase(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        delete(itemPosition)
                    }
                }
            }
        }

        private fun decrease(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.quantityTV.text = itemQuantities[position].toString()
            }
        }

        private fun increase(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.quantityTV.text = itemQuantities[position].toString()
            }
        }

        private fun delete(position: Int) {
            cartItems.removeAt(position)
            cartItemImage.removeAt(position)
            cartItemPrice.removeAt(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            CartItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
}