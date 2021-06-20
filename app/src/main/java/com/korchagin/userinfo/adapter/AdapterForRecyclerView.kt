package com.korchagin.userinfo.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.korchagin.userinfo.R
import com.korchagin.userinfo.model.People
import com.korchagin.userinfo.fragments.UserDetailsFragment
import kotlinx.android.synthetic.main.userlayout.view.*

class AdapterForRecyclerView(private val userList: List<People>):
    RecyclerView.Adapter<AdapterForRecyclerView.RecyclerViewHolder>() {
    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.tv_Name
        val textView2: TextView = itemView.tv_Surname
        val textView3: TextView = itemView.tv_Company
        val  imageView: ImageView = itemView.iv_Avatar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.userlayout,
        parent, false)

        return RecyclerViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.textView1.text = currentItem.name.toLowerCase().capitalize()
        holder.textView2.text = currentItem.surname.toLowerCase().capitalize()
        holder.textView3.text = currentItem.company

        Glide.with(holder.itemView.getContext())
            .load(currentItem.avatar_url)
            .into(holder.imageView);

        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                val activity = v!!.context as AppCompatActivity
                val fragment  = UserDetailsFragment()
                val bundle = Bundle()
                bundle.putSerializable("CUR_USER", currentItem)
                fragment.setArguments(bundle)
                val fragmentManager: FragmentManager = activity.supportFragmentManager
                val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container, fragment).addToBackStack(null)
                fragmentTransaction.commit()

            }
        } )
    }

    override fun getItemCount() = userList.size
}