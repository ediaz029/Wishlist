package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(val c: Context, private val items: ArrayList<WishlistItem>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){
    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){

        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTV)
            priceTextView = itemView.findViewById(R.id.priceTV)
            urlTextView = itemView.findViewById(R.id.urlTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.urlTextView.text = item.url
    }
}