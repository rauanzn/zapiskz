package com.example.zapiskz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Master
import com.example.zapiskz.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.master_item.view.*

class MastersAdapter(val context: Context):RecyclerView.Adapter<MastersAdapter.MasterViewHolder>(){
    val mastersList = ArrayList<Master>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.master_item,parent,false)
        return MasterViewHolder(view)
    }

    override fun getItemCount(): Int = mastersList.size

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        Picasso.get().load("http://zp.jgroup.kz${mastersList[position].avatarUrl}").into(holder.itemView.masterAvatar)
        holder.itemView.masterName.text = mastersList[position].name
        holder.itemView.profession.text = mastersList[position].profession
    }
    class MasterViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

}