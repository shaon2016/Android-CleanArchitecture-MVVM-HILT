package com.lastblade.androidarchitecturewithhilt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lastblade.androidarchitecturewithhilt.R
import com.lastblade.androidarchitecturewithhilt.data.model.User
import kotlinx.android.synthetic.main.rv_user_row.view.*

/**
 * Created by "Ashiq" on 01/15/2020.
 */

class UserRvAdapter(private val users: List<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyUserVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_user_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as MyUserVH
        val user = users[h.adapterPosition]
        h.bind(user)
    }

    private inner class MyUserVH(v: View) : RecyclerView.ViewHolder(v) {
        private val tvName = v.tvName
        fun bind(user: User) {
            tvName.text = user.name
        }
    }
}