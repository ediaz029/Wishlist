package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var items: ArrayList<WishlistItem>
    private lateinit var adapter : WishlistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = ArrayList()
        var wishlistRV: RecyclerView = findViewById(R.id.wishlistRV)
        adapter = WishlistAdapter(this, items)
        wishlistRV.layoutManager = LinearLayoutManager(this)
        wishlistRV.adapter = adapter


        findViewById<Button>(R.id.submitButton).setOnClickListener{

            val userItemName:EditText=findViewById(R.id.nameEntry)
            val userPrice:EditText=findViewById(R.id.priceEntry)
            val userURL:EditText=findViewById(R.id.urlEntry)

            val name = userItemName.text.toString()
            val price = userPrice.text.toString()
            val url = userURL.text.toString()
            items.add(WishlistItem(name, price, url))
            adapter.notifyDataSetChanged()

            userItemName.text.clear()
            userPrice.text.clear()
            userURL.text.clear()
        }
    }

}