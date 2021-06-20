package com.korchagin.userinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.korchagin.userinfo.R
import com.korchagin.userinfo.databinding.UserlayoutBinding
import com.korchagin.userinfo.model.PeopleResponse


class UsersAdapter (
    private val users: PeopleResponse
) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    
    override fun getItemCount() = users.people.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UsersViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.userlayout,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.recyclerviewUserBinding.people = users.people[position]
    }


    inner class UsersViewHolder(
        val recyclerviewUserBinding: UserlayoutBinding
    ) : RecyclerView.ViewHolder(recyclerviewUserBinding.root)

}