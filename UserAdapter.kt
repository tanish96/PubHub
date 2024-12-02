package com.example.pubhub.activities

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubhub.R
import com.example.pubhub.database.User

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImageView: ImageView = view.findViewById(R.id.profileImageView)
        val usernameTextView: TextView = view.findViewById(R.id.usernameTextView)
        val dobTextView: TextView = view.findViewById(R.id.dobTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        // Load the image using Glide without a placeholder
        Glide.with(holder.profileImageView.context)
            .load(Uri.parse(user.profileImageUri))
            .into(holder.profileImageView)

        holder.usernameTextView.text = user.username
        holder.dobTextView.text = user.dob
        holder.descriptionTextView.text = user.description
    }

    override fun getItemCount() = userList.size
}


