package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var items: MutableList<WishlistItem>
    lateinit var adapter : WishlistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = mutableListOf()
        val wishlistRV: RecyclerView = findViewById(R.id.wishlistRV)
        val userItemName:EditText=findViewById(R.id.nameEntry)
        val userPrice:EditText=findViewById(R.id.priceEntry)
        val userURL:EditText=findViewById(R.id.urlEntry)

        adapter = WishlistAdapter(items)
        wishlistRV.adapter = adapter
        wishlistRV.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.submitButton).setOnClickListener{

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