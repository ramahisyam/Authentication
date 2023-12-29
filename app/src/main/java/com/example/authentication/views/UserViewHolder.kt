package com.example.authentication.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.authentication.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val firstName: TextView = itemView.findViewById(R.id.first_name)
    val lastName: TextView = itemView.findViewById(R.id.last_name)
    val email: TextView = itemView.findViewById(R.id.email)
}