package com.example.munchmate.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.munchmate.databinding.NotificationsItemBinding

class NotificationAdapter(
    private val notification: ArrayList<String>,
    private val notificationIcon: ArrayList<Int>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    inner class NotificationViewHolder(private val binding: NotificationsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int){
                binding.apply {
                    notificationText.text = notification[position]
                    notificationImage.setImageResource(notificationIcon[position])
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            NotificationsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return notification.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }
}