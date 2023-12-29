package com.example.authentication.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.authentication.R
import com.example.authentication.models.User

class UserAdapter(private var data: List<User>) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = data[position]
        holder.firstName.text = currentItem.firstName
        holder.lastName.text = currentItem.lastName
        holder.email.text = currentItem.email
    }

    fun updateData(newList: List<User>) {
        data = newList
        notifyDataSetChanged() // Notify adapter that the dataset has changed
    }

}