package com.example.zapiskz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Firm
import com.example.zapiskz.listeners.OnShopClickListener
import com.example.zapiskz.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.beauty_shop_item.view.*

class BeautyShopAdapter(val context:Context, val onShopClickListener: OnShopClickListener): RecyclerView.Adapter<BeautyShopAdapter.BeautyShopViewHolder>() {
    val listOfItems = ArrayList<Firm>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeautyShopViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.beauty_shop_item,parent,false)
        return BeautyShopViewHolder(view)
    }

    override fun getItemCount(): Int = listOfItems.size

    override fun onBindViewHolder(holder: BeautyShopViewHolder, position: Int) {
        Picasso.get().load("http://zp.jgroup.kz${listOfItems[position].pictureUrl}").into(holder.itemView.imageViewShopItem)
        holder.itemView.textShopItem.text = listOfItems[position].name
        holder.bind(listOfItems[position])

    }
    inner class BeautyShopViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(firm: Firm){
            itemView.setOnClickListener {
                onShopClickListener.onShopClicked(firm.id)
            }
        }
    }
}