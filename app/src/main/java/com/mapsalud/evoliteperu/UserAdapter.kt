package com.mapsalud.evoliteperu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter (private val users: List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.firstName.text = user.name
        holder.lastName.text = user.lastname
    }

    override fun getItemCount() = users.size

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val firstName: TextView = itemView.findViewById(R.id.tvName)
        val lastName: TextView = itemView.findViewById(R.id.tvLastName)
    }
}